package com.aanchal.JobApplication.Jobs.Impl;

import com.aanchal.JobApplication.Jobs.JobRepository;
import com.aanchal.JobApplication.Jobs.JobService;
import com.aanchal.JobApplication.Jobs.Jobs;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class jobServiceImpl implements JobService {

//    List<Jobs> jobs=new ArrayList<>();

    JobRepository jobRepository;
    Long jobid= 1L;

    public jobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Jobs> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Jobs job) {



        jobRepository.save(job);
    }
    public Jobs getJobById(Long id){

            return jobRepository.findById(id).orElse(null);
        //getting an error 2:40
    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Jobs updatedjob) {

        Optional<Jobs> jobsOptional=jobRepository.findById(id);
        if(jobsOptional.isPresent()){
            Jobs jobs=jobsOptional.get();
            jobs.setId(id);

            jobs.setTitle(updatedjob.getTitle());
            jobs.setDescription(updatedjob.getDescription());
            jobs.setMinSalary(updatedjob.getMinSalary());
            jobs.setMaxSalary(updatedjob.getMaxSalary());
            jobs.setLocation(updatedjob.getLocation());
            jobRepository.save(jobs);
            return true;
        }
        return false;
    }
}
