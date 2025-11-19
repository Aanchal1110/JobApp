package com.aanchal.JobApplication.Jobs.Impl;

import com.aanchal.JobApplication.Jobs.JobService;
import com.aanchal.JobApplication.Jobs.Jobs;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Jobs> iterator=jobs.iterator();
        while(iterator.hasNext()){
            Jobs job=iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Jobs updatedjob) {
        for(Jobs job: jobs){
            if(job.getId().equals(id)){
                job.setTitle(updatedjob.getTitle());
                job.setDescription(updatedjob.getDescription());
                job.setMinSalary(updatedjob.getMinSalary());
                job.setMaxSalary(updatedjob.getMaxSalary());
                job.setLocation(updatedjob.getLocation());
                return true;
            }

        }
        return false;
    }
}
