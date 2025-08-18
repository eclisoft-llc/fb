package com.fbol.xaabatch.controller;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableScheduling
public class XaaController {


    @Autowired
    private JobLauncher customJobLauncher;
    @Autowired
    private Job xaaJob;


    @PostMapping
    public @ResponseBody Boolean startBatch() throws Exception{
        JobParameters params = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
        customJobLauncher.run(xaaJob, params);
        return true;
    }

    @Scheduled(zone = "America/Chicago", cron = "${cron}")
    public void cronCaller() throws Exception {
        this.startBatch();
    }


}
