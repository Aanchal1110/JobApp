package com.aanchal.JobApplication.Jobs.Impl;

import com.aanchal.JobApplication.Jobs.JobService;
import com.aanchal.JobApplication.Jobs.Jobs;

import java.util.ArrayList;
import java.util.List;

public class jobServiceImpl implements JobService {

    List<Jobs> jobs=new ArrayList<>();
    @Override
    public List<Jobs> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Jobs job) {
        jobs.add(job);
    }
}
