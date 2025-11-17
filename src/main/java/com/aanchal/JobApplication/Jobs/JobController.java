package com.aanchal.JobApplication.Jobs;

import java.util.ArrayList;
import java.util.List;

public class JobController {

    private List<Jobs> jobs=new ArrayList<>();
    public List<Jobs> findAll(){
        return jobs;
    }
}
