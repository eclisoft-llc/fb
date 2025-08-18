package com.fbol.paysafebatch.batch.paysafeinputfilejob.responsestep;

import com.fbol.paysafebatch.models.paysafeinput.InputFile;
import com.fbol.paysafebatch.models.paysafeinput.enums.ProcessStatus;
import com.fbol.paysafebatch.repository.paysafeinput.InputFileRepository;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Configuration
public class ResponseStep {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private InputFileRepository fileRepository;
    @Autowired
    private ResponseProcessor responseProcessor;

    public Step responseStep(JpaTransactionManager transactionManager) {
        return stepBuilderFactory.get("responseStep")
                .transactionManager(transactionManager)
                .<InputFile, InputFile>chunk(1)
                .reader(responseReader()).processor(responseProcessor)
                .writer(responseWriter()).build();
    }

    @Bean
    public RepositoryItemReader<InputFile> responseReader() {
        RepositoryItemReader<InputFile> reader = new RepositoryItemReader<>();
        reader.setRepository(fileRepository);
        reader.setMethodName("findByStatus");
        List<Object> queryArgs = new ArrayList<>();
        queryArgs.add(ProcessStatus.Read);
        reader.setArguments(queryArgs);
        reader.setPageSize(100);
        Map<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);
        reader.setSort(sorts);
        return reader;
    }


    @Bean
    public RepositoryItemWriter<InputFile> responseWriter() {
        RepositoryItemWriter<InputFile> writer = new RepositoryItemWriter<>();
        writer.setRepository(fileRepository);
        writer.setMethodName("save");
        return writer;
    }
}