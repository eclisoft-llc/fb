package com.fbol.paysafebatch.controller;

import com.fbol.paysafebatch.models.paysafeinput.InputFile;
import com.fbol.paysafebatch.models.paysafeinput.enums.ProcessStatus;
import com.fbol.paysafebatch.repository.paysafeinput.InputFileRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/paysafe")
@EnableScheduling
public class PaysafeFileInputController {
    @Autowired
    private InputFileRepository repository;

    @Autowired
    private JobLauncher customJobLauncher;
    @Autowired
    private Job paysafeInputJob;
    @Autowired
    private Job paysafeRetryJob;

    @GetMapping
    public @ResponseBody Iterable<InputFile> getAllFiles() {
        // This returns a JSON or XML with the users
        return repository.findAll();
    }

    @PostMapping
    public @ResponseBody Boolean startBatch() throws Exception{
        JobParameters params = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
        customJobLauncher.run(paysafeInputJob, params);
        return true;
    }

    @GetMapping(path="/{id}")
    public @ResponseBody InputFile getFile(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("File not found"));
    }

    @PostMapping(path="/{id}")
    public @ResponseBody Boolean restartBatch(@PathVariable Integer id) throws Exception{
        var file = repository.findById(id).orElseThrow(() -> new RuntimeException("File not found"));
        file.updateStatusCascade(ProcessStatus.Read);
        repository.save(file);
        // re-trigger batch
        JobParameters params = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
        customJobLauncher.run(paysafeRetryJob, params);
        return true;
    }

    @Scheduled(zone = "America/Chicago", cron = "${cron}")
    public void cronCaller() throws Exception {
        this.startBatch();
    }
}
