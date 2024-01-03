package com._hr.humanR.controllers;

import com._hr.humanR.entity.JobsEntity;
import com._hr.humanR.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {
    @Autowired
    private JobService jobService;
    @GetMapping("/jobs")
    public List<JobsEntity> getJobs(){
        return jobService.getJobs();
    }

    @GetMapping("/jobs/{id}")
    public JobsEntity getJob(@PathVariable String id){
        return jobService.getJob(id);
    }

    @PostMapping("/jobs")
    @ResponseStatus(HttpStatus.CREATED)
    public JobsEntity saveJob(@RequestBody JobsEntity job){
        return jobService.saveJob(job);
    }

    @PutMapping("/jobs/{id}")
    public JobsEntity updateJob(@RequestBody JobsEntity job, @PathVariable String id){
        JobsEntity JobsEntityActual =  jobService.getJob(id);
        JobsEntityActual.setJobTitle(job.getJobTitle());
        JobsEntityActual.setMinSalary(job.getMinSalary());
        JobsEntityActual.setMaxSalary(job.getMaxSalary());
        return jobService.saveJob(JobsEntityActual);
    }

    @DeleteMapping("/jobs/{id}")
    public void deleteJob(@PathVariable String id){
        jobService.deleteJob(id);
    }

    @PostMapping("/jobsTen")
    public List<JobsEntity> findTenThousand(@RequestBody Integer salary){
        return jobService.getMaxTenThousand(salary);
    }
}
