package com.aanchal.JobApplication.Jobs;

import org.springframework.stereotype.Service;

import java.util.List;


public interface JobService {
    List<Jobs> findAll();
    void createJob(Jobs job);

    Jobs getJobById(Long id);
}
