package com.aanchal.JobApplication.Jobs;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/jobs") //requestMapping helps in setting the base url so that we have to writeit again and agian
@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

//    @GetMapping("/jobs") ->before RequestMapping at class level
@GetMapping
    public ResponseEntity<
            List<Jobs>> findAll(){

        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

//    @PostMapping("/jobs")
@PostMapping
    public ResponseEntity<String> createJob(@RequestBody Jobs job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);

    }
//    @GetMapping("/jobs/{id}") ->before RequestMapping at class level
@GetMapping("/{id}")
    public ResponseEntity<Jobs> getJobbyId(@PathVariable Long id){
        Jobs job=jobService.getJobById(id);
        if(job!=null){
            return new ResponseEntity<>(job,HttpStatus.OK) ;
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//    @DeleteMapping("/jobs/{id}") before RequestMapping at class level
@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean deleted=jobService.deleteJobById(id);
        if(deleted){
            return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Deletion failed", HttpStatus.NOT_FOUND);
    }

//    @PutMapping("/jobs/{id}") ->before RequestMapping at class level
//    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.PUT) ->RequestMapping at method level
@PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Jobs updatedjob){
        boolean updated=jobService.updateJob(id, updatedjob);
        if(updated){
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Could not update", HttpStatus.NOT_FOUND);

    }
}
