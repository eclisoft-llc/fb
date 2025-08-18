package com.fbol.xaabatch.model;

import com.azure.storage.blob.BlobClient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.batch.item.ResourceAware;
import org.springframework.core.io.Resource;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Xaa implements ResourceAware {


   private String accountnumber;
   private String fullstatementnumber;
   private LocalDate statementdate;
   private String filename;
   private Resource resource;


    public final static List<BlobClient> processedfiles = new ArrayList<>();


    @Override
    public void setResource(Resource resource) {

        this.resource=resource;

    }
}

