package com.fbol.xaabatch.batch;

import com.fbol.xaabatch.model.Xaa;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobResultListener implements JobExecutionListener {

	public void beforeJob(JobExecution jobExecution) {

	}

	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED ) {
	        //job success

			Xaa.processedfiles.forEach(i -> i.delete());
	    }
	    else if (jobExecution.getStatus() == BatchStatus.FAILED) {
	        //job failure
	    }
	}
}