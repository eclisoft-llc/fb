package com.fbol.paysafebatch.batch.paysafeinputfilejob.retrievestep;

import com.fbol.paysafebatch.models.paysafeinput.InputFile;
import com.fbol.paysafebatch.repository.paysafeinput.InputFileRepository;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Configuration
public class RetrieveStep {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private RetrieveReader retrieveReader;
    @Autowired
    private RetrieveProcessor retrieveProcessor;
    @Autowired
    @Lazy
    private InputFileRepository fileRepository;

    public Step retrieveStep(JpaTransactionManager transactionManager){
        return stepBuilderFactory.get("retrieveStep")
                .transactionManager(transactionManager)
                .<ArrayList<String>, InputFile> chunk(1)
                .reader(retrieveReader).processor(retrieveProcessor)
                .writer(retrieveWriter()).build();
    }

    @Bean
    public RepositoryItemWriter<InputFile> retrieveWriter(){
        RepositoryItemWriter<InputFile> writer = new RepositoryItemWriter<>();
        writer.setRepository(fileRepository);
        writer.setMethodName("save");
        return writer;
    }
}
