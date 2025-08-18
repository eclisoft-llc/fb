package com.fbol.paysafebatch.batch.paysafeinputfilejob.transactionstep;

import com.fbol.paysafebatch.models.paysafeinput.InputEntry;
import com.fbol.paysafebatch.models.paysafeinput.enums.NonApprovalCode;
import com.fbol.paysafebatch.models.paysafeinput.enums.ProcessStatus;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class TransactionProcessor implements ItemProcessor<InputEntry, InputEntry> {
    @Value("${code_connect.url}")
    private String codeConnectUrl;

    @Override
    public InputEntry process(InputEntry entry) throws Exception {
        String firstRequest = "";
        String internalRequest = "";

        try{
            firstRequest = entry.getTransactionJson(false);
            internalRequest = entry.getTransactionJson(true);
        } catch(Exception e){
            updateEntryFailed(entry, true, e.getMessage(), NonApprovalCode.CouldNotPost);
            return entry;
        }

        try {
            // Do the first request here and set the appropriate code;
            String resp = this.makeRequest(firstRequest);
            entry.setDpTxnCtrlNbr(resp);
        } catch(HttpStatusCodeException e){
            // Log what the error was, but it isn't an error that requires action.
            this.updateEntryFailedWithResponse(entry, false, e.getResponseBodyAsString());
            return entry;
        } catch(Exception e){
            this.updateEntryFailed(entry, true, e.getMessage(), NonApprovalCode.CouldNotPost);
            return entry;
        }

        try {
            // Do the second request.
            String resp = this.makeRequest(internalRequest);
            entry.setDpTxnCtrlNbrInternal(resp);
            entry.setError(false);
            entry.setStatus(ProcessStatus.Proccessed);
            entry.setTransactionApproval(true);
            return entry;
        } catch(HttpStatusCodeException e) {
            // Error requires Someone to review it.
            this.updateEntryFailed(entry, true, e.getResponseBodyAsString(), NonApprovalCode.CouldNotPost);
            return entry;
        } catch(Exception e){
            this.updateEntryFailed(entry, true, e.getMessage(), NonApprovalCode.CouldNotPost);
            return entry;
        }
    }

    private void updateEntryFailed(InputEntry entry, boolean isError, String errorMessage, NonApprovalCode code){
        entry.setError(isError);
        entry.setErrorMsg(errorMessage);
        entry.setStatus(ProcessStatus.Proccessed);
        entry.setTransactionApproval(false);
        entry.setNonApprovalCode(code);
    }


    private void updateEntryFailedWithResponse(InputEntry entry, boolean isError, String resp){
        NonApprovalCode code = NonApprovalCode.CouldNotPost;
        List<String> codes01 = Arrays.asList("D607026", "D607027", "D607057");
        List<String> codes02 = Arrays.asList("D607006");
        List<String> codes03 = Arrays.asList("D607004", "D607005", "D607007", "D607024", "D607025", "D607034");

        try{
            JSONArray msgLst = new JSONObject(resp).getJSONObject("Metadata").getJSONArray("MsgLst");
            for(int i = 0; i < msgLst.length(); i++){
                JSONObject msg = msgLst.getJSONObject(i);
                String fisCode = msg.optString("Code");
                if(fisCode != null && codes01.contains(fisCode)){
                    code = NonApprovalCode.InsufficientFunds;
                }
                if(fisCode != null && codes02.contains(fisCode)){
                    code = NonApprovalCode.AccountClosed;
                }
                if(fisCode != null && codes03.contains(fisCode)){
                    code = NonApprovalCode.InvalidAccount;
                }
            }
        } catch(Exception e){
            // JSON error. Return object was not in expected format. Return the default code.
        }
        updateEntryFailed(entry, isError, resp, code);
    }

    private String makeRequest(String entity){
        String fullUrl = codeConnectUrl + "/transaction/simple?retry=true";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<String>(entity, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(fullUrl, request, String.class);
        if(response.getStatusCode().isError()){
            throw new HttpClientErrorException(response.getStatusCode(), response.getBody());
        }
        JSONObject object = new JSONObject(response.getBody());
        return object.getJSONObject("Entity").getJSONObject("singleSimpleDollarTransaction").getBigInteger("DPTxnCntlNbr").toString();
    }
}