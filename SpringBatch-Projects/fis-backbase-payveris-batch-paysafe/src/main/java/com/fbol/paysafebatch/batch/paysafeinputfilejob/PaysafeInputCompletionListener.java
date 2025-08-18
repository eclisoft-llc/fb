package com.fbol.paysafebatch.batch.paysafeinputfilejob;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class PaysafeInputCompletionListener extends JobExecutionListenerSupport {

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            // TODO: Send success emails to the needed parties. Find any errors and give report of them.
        } else if(jobExecution.getStatus() == BatchStatus.FAILED) {
            // TODO: Send failed email with the file id.
        }
    }
}
