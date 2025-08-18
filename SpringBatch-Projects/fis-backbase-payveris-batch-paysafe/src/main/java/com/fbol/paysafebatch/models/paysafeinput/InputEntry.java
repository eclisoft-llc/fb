package com.fbol.paysafebatch.models.paysafeinput;

import com.fbol.paysafebatch.models.paysafeinput.enums.NonApprovalCode;
import com.fbol.paysafebatch.models.paysafeinput.enums.PaysafeTransactionType;
import com.fbol.paysafebatch.models.paysafeinput.enums.ProcessStatus;
import com.fbol.paysafebatch.models.paysafeinput.enums.TransactionCode;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.DecimalFormat;

@Entity
public class InputEntry implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private InputBatch batch;
    private ProcessStatus status;
    private Boolean isError; // indicator for major error.
    @Lob
    private String errorMsg; // if first request fails. this will be the error message.
    private String dpTxnCtrlNbr; // Confirmation number from Core connect.
    private String dpTxnCtrlNbrInternal;


    // Fields from file.
    private PaysafeTransactionType transactionType;
    private TransactionCode transactionCode;
    private BigInteger routingNumber;
    private BigInteger accountNumber;
    private double amount;
    private BigInteger confirmationNumber;
    private String consumerName;
    private BigInteger transactionTraceNumber;
    private String transactionDescription;
    private String payeeName;
    private String payeeAccountNumber;
    private String coreSpecificCode;

    // Fields for the response file.
    private Boolean transactionApproval;
    private NonApprovalCode nonApprovalCode;

    public String getTransactionJson(boolean isInternalPosting) throws Exception {
        StringBuilder sb = new StringBuilder();
        String transactionCode = getTranCode(isInternalPosting);
        String transactionDescription = getTranDesc(isInternalPosting);
        var accNumber = this.accountNumber;
        if(isInternalPosting){
            accNumber = this.batch.getHoldingAccountNumber();
        }
        sb.append("{\n    \"single-simple-dollar-transaction\": {\n");
        sb.append("        \"DPAcctNbr\": " + accNumber + ",\n");
        sb.append("        \"DPTxnCde\": " + transactionCode + ",\n");
        sb.append("        \"DPLogTyp\": \"L\",\n");
        sb.append("        \"DPTxnTrlrDesc1\": \"" + transactionDescription + "\",\n");
        if (this.payeeName.length() < 19) {
            sb.append("        \"DPTxnTrlrDesc2\": \"" + this.payeeName + "\",\n");
        } else{
            String first = this.payeeName.substring(0, 18);
            sb.append("        \"DPTxnTrlrDesc2\": \"" + first + "\",\n");
            if(this.payeeName.length() < 37){
                String last = this.payeeName.substring(18);
                sb.append("        \"DPTxnTrlrDesc3\": \"" + last + "\",\n");
            } else {
                String last = this.payeeName.substring(18, 36);
                sb.append("        \"DPTxnTrlrDesc3\": \"" + last + "\",\n");
            }
        }
        sb.append("        \"DPTxnTrlrDesc4\": \"" + this.confirmationNumber + "\",\n");
        sb.append("        \"DPTxnAmt\": " + this.amount + ",\n");
        sb.append("        \"CustDefMsgSrc1\": \"Payveris\"\n    }\n}");

        return sb.toString();
    }

    private String getTranCode(boolean isInternalPosting) throws Exception {
        if(isInternalPosting){
            if(this.transactionCode.equals(TransactionCode.CR)){
                return "829";
            }
            return  "629";
        }

        switch (this.transactionType){
            case ON_US:
            case BP_PIN:
                if(this.transactionCode.equals(TransactionCode.DB)){
                    return "155";
                }
                throw new Exception("Transaction type should not exist as a credit");
            case RETURN_BILL_PAY:
            case RETURN_TRANSFER:
            case RETURN_PIN:
                if(this.transactionCode.equals(TransactionCode.DB)){
                    return "829";
                }
                return "629";
            case PIN:
                if(this.transactionCode.equals(TransactionCode.DB)){
                    return "156";
                }
                throw new Exception("Transaction type should not exist as a credit");
            case EXT_TRANSFER:
                if(this.transactionCode.equals(TransactionCode.DB)){
                    return "316";
                }
                return "116";
        }
        throw new Exception("Missing type of transaction.");
    }

    private String getTranDesc(boolean isInternalPosting) throws Exception {
        if(isInternalPosting){
            return String.valueOf(this.accountNumber);
        }

        switch (this.transactionType){
            case ON_US:
            case BP_PIN:
                return "Online Bill Pay";
            case RETURN_BILL_PAY:
                return "Return Bill Pay";
            case RETURN_TRANSFER:
                return "Return Transfer";
            case PIN:
                return "P2P";
            case RETURN_PIN:
                return "Return P2P";
            case EXT_TRANSFER:
                return "External Transfer";
        }
        throw new Exception("Missing type of transaction.");
    }

    // Override Methods
    @Override
    public String toString(){
        String nl = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        sb.append("{" + nl);
        sb.append("   \"id\": " + id + "," + nl);
        sb.append("   \"status\": \"" + status + "\"," + nl);
        sb.append("   \"isError\": " + isError + "," + nl);
        sb.append("   \"errorMsg\": \"" + errorMsg + "\"," + nl);
        sb.append("   \"dpTxnCtrlNbr\": " + dpTxnCtrlNbr + "," + nl);
        sb.append("   \"transactionType\": \"" + transactionType + "\"," + nl);
        sb.append("   \"transactionCode\": \"" + transactionCode + "\"," + nl);
        sb.append("   \"routingNumber\": " + routingNumber + "," + nl);
        sb.append("   \"accountNumber\": " + accountNumber + "," + nl);
        sb.append("   \"amount\": " + amount + "," + nl);
        sb.append("   \"confirmationNumber\": " + confirmationNumber + "," + nl);
        sb.append("   \"consumerName\": \"" + consumerName + "\"," + nl);
        sb.append("   \"transactionTraceNumber\": " + transactionTraceNumber + "," + nl);
        sb.append("   \"transactionDescription\": \"" + transactionDescription + "\"," + nl);
        sb.append("   \"payeeName\": \"" + payeeName + "\"," + nl);
        sb.append("   \"payeeAccountNumber\": \"" + payeeAccountNumber + "\"," + nl);
        sb.append("   \"coreSpecificCode\": \"" + coreSpecificCode + "\"," + nl);
        sb.append("   \"transactionApproval\": " + transactionApproval + "," + nl);
        sb.append("   \"nonApprovalCode\": \"" + nonApprovalCode + "\"" + nl);
        sb.append("}");

        return sb.toString();
    }

    // Response generator.
    public String generateResponse(){
        StringBuilder sb = new StringBuilder();
        sb.append("DE");// 1-2
        sb.append(StringUtils.rightPad(this.transactionType.toString(), 15, ' ')); // 3-17
        sb.append(this.transactionCode.toString()); // 18-19
        sb.append(StringUtils.leftPad(this.routingNumber.toString(), 9, '0')); // 20-28
        sb.append(StringUtils.leftPad(this.accountNumber.toString(), 17, '0')); // 29-45
        sb.append(new DecimalFormat("0000000.00").format(this.amount)); // 46-55
        sb.append(StringUtils.leftPad(this.confirmationNumber.toString(), 15, '0')); // 56-70
        sb.append(StringUtils.rightPad(this.consumerName.toString(), 45, ' ')); // 71-115
        sb.append(StringUtils.leftPad(this.transactionTraceNumber.toString(), 15, '0')); // 116-130
        sb.append(StringUtils.rightPad(this.transactionDescription, 20, ' ')); // 131-150
        sb.append(StringUtils.rightPad(this.payeeName, 36, ' ')); // 151-186
        sb.append(StringUtils.rightPad(this.payeeAccountNumber, 24, ' ')); // 187-210
        sb.append(StringUtils.rightPad(this.coreSpecificCode, 10, ' ')); // 211-220
        if(this.transactionApproval){ //221
            sb.append("Y");
            sb.append("          "); // 222-231
        } else{
            sb.append("N");
            sb.append(StringUtils.rightPad(this.nonApprovalCode.toString(), 10, ' ')); // 222-231;
        }
        for(int i = 0; i < 19; i++){ // 232-250
            sb.append(" ");
        }

        return sb.toString();
    }

    // Constructors.
    public InputEntry(){
        this.status = ProcessStatus.New;
        this.isError = false;
        this.transactionApproval = false;
    }

    public InputEntry(String unparsed) {
        this.transactionType =  PaysafeTransactionType.valueOfLabel(StringUtils.substring(unparsed, 2, 17).trim());
         this.transactionCode = TransactionCode.valueOfLabel((StringUtils.substring(unparsed, 17, 19)));
        this.routingNumber = new BigInteger(StringUtils.substring(unparsed, 19, 28));
        this.accountNumber = new BigInteger(StringUtils.substring(unparsed, 28, 45));
        this.amount = Double.parseDouble(StringUtils.substring(unparsed, 45, 55));
        this.confirmationNumber = new BigInteger(StringUtils.substring(unparsed, 55, 70));
        this.consumerName = StringUtils.substring(unparsed, 70, 115).trim();
        this.transactionTraceNumber = new BigInteger(StringUtils.substring(unparsed, 115, 130));
        this.transactionDescription = StringUtils.substring(unparsed, 130, 150).trim();
        this.payeeName = StringUtils.substring(unparsed, 150, 186).trim();
        this.payeeAccountNumber = StringUtils.substring(unparsed, 186, 210).trim();
        this.coreSpecificCode = StringUtils.substring(unparsed, 210, 220).trim();
        this.status = ProcessStatus.Read;
        this.isError = false;
        this.transactionApproval = false;
    }

    // Getters and setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PaysafeTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(PaysafeTransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionCode getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(TransactionCode transactionCode) {
        this.transactionCode = transactionCode;
    }

    public BigInteger getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(BigInteger routingNumber) {
        this.routingNumber = routingNumber;
    }

    public BigInteger getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(BigInteger accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BigInteger getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(BigInteger confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public BigInteger getTransactionTraceNumber() {
        return transactionTraceNumber;
    }

    public void setTransactionTraceNumber(BigInteger transactionTraceNumber) {
        this.transactionTraceNumber = transactionTraceNumber;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeAccountNumber() {
        return payeeAccountNumber;
    }

    public void setPayeeAccountNumber(String payeeAccountNumber) {
        this.payeeAccountNumber = payeeAccountNumber;
    }

    public String getCoreSpecificCode() {
        return coreSpecificCode;
    }

    public void setCoreSpecificCode(String coreSpecificCode) {
        this.coreSpecificCode = coreSpecificCode;
    }

    public InputBatch getBatch() {
        return batch;
    }

    public void setBatch(InputBatch batch) {
        this.batch = batch;
    }

    public ProcessStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessStatus status) {
        this.status = status;
    }

    public Boolean getTransactionApproval() {
        return transactionApproval;
    }

    public void setTransactionApproval(Boolean transactionApproval) {
        this.transactionApproval = transactionApproval;
    }

    public NonApprovalCode getNonApprovalCode() {
        return nonApprovalCode;
    }

    public void setNonApprovalCode(NonApprovalCode nonApprovalCode) {
        this.nonApprovalCode = nonApprovalCode;
    }

    public Boolean getError() {
        return isError;
    }

    public void setError(Boolean error) {
        isError = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg1) {
        this.errorMsg = errorMsg1;
    }

    public String getDpTxnCtrlNbr() {
        return dpTxnCtrlNbr;
    }

    public void setDpTxnCtrlNbr(String dpTxnCtrlNbr) {
        this.dpTxnCtrlNbr = dpTxnCtrlNbr;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDpTxnCtrlNbrInternal() {
        return dpTxnCtrlNbrInternal;
    }

    public void setDpTxnCtrlNbrInternal(String dpTxnCtrlNbrInternal) {
        this.dpTxnCtrlNbrInternal = dpTxnCtrlNbrInternal;
    }
}
