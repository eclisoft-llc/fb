package com.fbol.xaabatch.batch;


import com.azure.spring.autoconfigure.storage.resource.AzureStorageResourcePatternResolver;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import com.fbol.xaabatch.model.Xaa;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class XaaReader implements ItemReader<MultiResourceItemReader<Xaa>> {

    @Value("${azure.storage_connection_string}")
    private String blobConn;
    private final String incomingLocation = "xaa-account-incoming";
    private final String incomingArchiveLocation = "xaa-account-incoming-archive";

    @Override
    public MultiResourceItemReader<Xaa> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {



        // Set up clients.
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(blobConn).buildClient();
        BlobContainerClient incomingContainerClient = blobServiceClient.getBlobContainerClient(incomingLocation);
        BlobContainerClient archiveContainerClient = blobServiceClient.getBlobContainerClient(incomingArchiveLocation);
        AzureStorageResourcePatternResolver storageResourcePatternResolver = new AzureStorageResourcePatternResolver(blobServiceClient);

        List<Resource> resources = new ArrayList<>();

        // Find blobs.
        for (BlobItem blobItem : incomingContainerClient.listBlobs()){
            if(!blobItem.isDeleted()){
                // Retrieve blob.
                BlobClient incomingBlobClient = incomingContainerClient.getBlobClient(blobItem.getName());

                // Input retrieved
                BlobClient archiveBlobClient = archiveContainerClient.getBlobClient(blobItem.getName());

                Resource resource = storageResourcePatternResolver.getResource("azure-blob://"+incomingLocation+"/"+blobItem.getName());
                resources.add(resource);

                // Save a copy to the archive location.
                archiveBlobClient.beginCopy(incomingBlobClient.getBlobUrl(),null);

                Xaa.processedfiles.add(incomingBlobClient);
                //return reader;
            }
        }

        Resource[] allfiles = new Resource[resources.size()];
        resources.toArray(allfiles);

        MultiResourceItemReader<Xaa> reader = new MultiResourceItemReader<>();
        reader.setResources(allfiles);
        reader.setDelegate(xaaFlatFileItemReader(reader));

        return reader;
    }

    private FlatFileItemReader<Xaa> xaaFlatFileItemReader(MultiResourceItemReader delegator) throws Exception {
        FlatFileItemReader<Xaa> reader = new FlatFileItemReader<>();
        reader.setLinesToSkip(1); // header row
        reader.setLineMapper(new XaaLineMapper(delegator));
        reader.afterPropertiesSet();

        return reader;
    }

}
