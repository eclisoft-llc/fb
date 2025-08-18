package com.fbol.paysafebatch.batch.paysafeinputfilejob.retrievestep;

import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RetrieveReader implements ItemReader<ArrayList<String>>{ //grab the file and parse it into individual fields.
    @Value("${azure.storage_connection_string}")
    private String blobConn;

    private final String incomingLocation = "paysafe-payments-incoming";
    private final String incomingArchiveLocation = "paysafe-payments-incoming-archive";

    @Override
    public ArrayList<String> read() {
        // Set up clients.
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(blobConn).buildClient();
        BlobContainerClient incomingContainerClient = blobServiceClient.getBlobContainerClient(incomingLocation);
        BlobContainerClient archiveContainerClient = blobServiceClient.getBlobContainerClient(incomingArchiveLocation);

        // Find blobs.
        for (BlobItem blobItem : incomingContainerClient.listBlobs()){
            if(!blobItem.isDeleted()){
                // Retrieve blob.
                BlobClient incomingBlobClient = incomingContainerClient.getBlobClient(blobItem.getName());
                BinaryData originalData = incomingBlobClient.downloadContent();
                String data = originalData.toString();

                // Input retrieved save a copy to the archive location.
                BlobClient archiveBlobClient = archiveContainerClient.getBlobClient(blobItem.getName());
                archiveBlobClient.upload(originalData);

                // Archive saved. Delete old blob.
                incomingBlobClient.delete();
                ArrayList<String> resp = new ArrayList<String>(List.of(data.replaceAll("\r\n", "\n").split("\n")));
                resp.add(0, blobItem.getName());
                return resp;
            }
        }
        return null;
    }
}