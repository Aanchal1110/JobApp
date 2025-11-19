package com.aanchal.JobApplication.Jobs;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Jobs> findAll(){

        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Jobs job){
        jobService.createJob(job);
        return "Job Added Successfully";

    }
    @GetMapping("/jobs/{id}")
    public Jobs getJobbyId(@PathVariable Long id){
        Jobs job=jobService.getJobById(id);
        if(job!=null){
            return job;
        }
        return new Jobs(101L, "test","test","test","test", "loc");
    }
}
