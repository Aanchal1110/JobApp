package com.aanchal.JobApplication.Jobs;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class JobController {

    private List<Jobs> jobs=new ArrayList<>();
    @GetMapping("/jobs")
    public List<Jobs> findAll(){
        return jobs;
    }
}
