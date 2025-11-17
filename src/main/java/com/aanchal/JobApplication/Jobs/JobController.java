package com.aanchal.JobApplication.Jobs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private List<Jobs> jobs=new ArrayList<>();
    @GetMapping("/jobs")
    public List<Jobs> findAll(){
        return jobs;
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Jobs job){
        jobs.add(job);
        return "Job Added Successfully";

    }
}
