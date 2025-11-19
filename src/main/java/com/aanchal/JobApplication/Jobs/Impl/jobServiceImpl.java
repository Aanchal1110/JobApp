package com.aanchal.JobApplication.Jobs.Impl;

import com.aanchal.JobApplication.Jobs.JobService;
import com.aanchal.JobApplication.Jobs.Jobs;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class jobServiceImpl implements JobService {

    List<Jobs> jobs=new ArrayList<>();
    Long jobid= 1L;
    @Override
    public List<Jobs> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Jobs job) {

        job.setId(jobid++);

        jobs.add(job);
    }
    public Jobs getJobById(Long id){
        for(Jobs job:jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
        //getting an error 2:40
    }
}
