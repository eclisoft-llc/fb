package com.fbol.paysafebatch.batch.paysafeinputfilejob.transactionstep;

import com.fbol.paysafebatch.models.paysafeinput.InputEntry;
import com.fbol.paysafebatch.models.paysafeinput.enums.ProcessStatus;
import com.fbol.paysafebatch.repository.paysafeinput.InputEntryRepository;
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
public class TransactionStep {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private InputEntryRepository entryRepository;
    @Autowired
    private TransactionProcessor transactionProcessor;

    public Step transactionStep(JpaTransactionManager transactionManager){
        return stepBuilderFactory.get("transactionStep")
                .transactionManager(transactionManager)
                .<InputEntry, InputEntry> chunk(1)
                .reader(transactionReader()).processor(transactionProcessor)
                .writer(transactionWriter()).build();
    }

    @Bean
    public RepositoryItemReader<InputEntry> transactionReader(){
        RepositoryItemReader<InputEntry> reader = new RepositoryItemReader<>();
        reader.setRepository(entryRepository);
        reader.setMethodName("findByStatus");

        List<Object> queryArgs = new ArrayList<>();
        queryArgs.add(ProcessStatus.Read);

        reader.setArguments(queryArgs);
        reader.setPageSize(2147483647);

        Map<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);
        reader.setSort(sorts);

        return reader;
    }

    @Bean
    public RepositoryItemWriter<InputEntry> transactionWriter() {
        RepositoryItemWriter<InputEntry> writer = new RepositoryItemWriter<>();
        writer.setRepository(entryRepository);
        writer.setMethodName("save");
        return writer;
    }
}
