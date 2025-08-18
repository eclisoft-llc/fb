package com.fbol.paysafebatch.batch;

import com.fbol.paysafebatch.batch.paysafeinputfilejob.PaysafeInputCompletionListener;
import com.fbol.paysafebatch.batch.paysafeinputfilejob.responsestep.ResponseStep;
import com.fbol.paysafebatch.batch.paysafeinputfilejob.retrievestep.RetrieveStep;
import com.fbol.paysafebatch.batch.paysafeinputfilejob.transactionstep.TransactionStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private RetrieveStep retrieveStep;
    @Autowired
    private TransactionStep transactionStep;
    @Autowired
    private ResponseStep responseStep;

    @Bean
    public Job paysafeInputJob() {
        return jobBuilderFactory.get("paysafeInputJob")
                .listener(listener())
                .start(retrieveStep.retrieveStep(jpaTransactionManager()))
                .next(transactionStep.transactionStep(jpaTransactionManager()))
                .next(responseStep.responseStep(jpaTransactionManager()))
                .build();
    }

    @Bean
    public Job paysafeRetryJob() {
        return jobBuilderFactory.get("paysafeRetryJob")
                .listener(listener())
                .start(transactionStep.transactionStep(jpaTransactionManager()))
                .next(responseStep.responseStep(jpaTransactionManager()))
                .build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new PaysafeInputCompletionListener();
    }

    @Override
    public void setDataSource(DataSource dataSource) {
    }

    @Bean
    @Primary
    public JpaTransactionManager jpaTransactionManager(){
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        return transactionManager;
    }
}