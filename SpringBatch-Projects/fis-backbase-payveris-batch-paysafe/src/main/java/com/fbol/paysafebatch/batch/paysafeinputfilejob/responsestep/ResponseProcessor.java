package com.fbol.paysafebatch.batch.paysafeinputfilejob.responsestep;

import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.fbol.paysafebatch.models.paysafeinput.InputFile;
import com.fbol.paysafebatch.models.paysafeinput.enums.ProcessStatus;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ResponseProcessor implements ItemProcessor<InputFile, InputFile> {
    @Value("${azure.storage_connection_string}")
    private String blobConn;

    private final String outgoingLocation = "paysafe-payments-outgoing";

    @Override
    public InputFile process(InputFile file) throws Exception {
        if(file.getTotalApprovedCreditTransactions() + file.getTotalApprovedDebitTransactions() == 0){
            System.out.println("All failed. This process needs a human adult.");
            file.updateStatusCascade(ProcessStatus.Finished);
            // TODO: add on emailing for error where none worked.
            // If none of them worked. dont send the file and we will look over why it failed.
            return file;
        }
        // Set up clients.
        String blobName = file.getFileName().substring(0, file.getFileName().length() - 4) + ".in";
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(blobConn).buildClient();
        BlobContainerClient outgoingContainerClient = blobServiceClient.getBlobContainerClient(outgoingLocation);
        BlobClient outgoingBlobClient = outgoingContainerClient.getBlobClient(blobName);
        ArrayList<String> response = file.GenerateFileResponse();
        StringBuilder sb = new StringBuilder();
        for(String line: response){
            sb.append(line + System.lineSeparator());
        }
        outgoingBlobClient.upload(BinaryData.fromString(sb.toString()));
        file.updateStatusCascade(ProcessStatus.Finished);
        return file;
    }
}
