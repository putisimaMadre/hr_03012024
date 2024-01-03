package com._hr.humanR.service.impl;

import com._hr.humanR.entity.JobsEntity;
import com._hr.humanR.repository.JobRepository;
import com._hr.humanR.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    @Override
    public List<JobsEntity> getJobs() {
        return jobRepository.findAll();
    }

    @Override
    public JobsEntity saveJob(JobsEntity job) {
        return jobRepository.save(job);
    }

    @Override
    public JobsEntity getJob(String id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteJob(String id) {
        jobRepository.deleteById(id);
    }

    @Override
    public List<JobsEntity> getMaxTenThousand(Integer salary) {
        return jobRepository.findTenThousand(salary);
    }

}
