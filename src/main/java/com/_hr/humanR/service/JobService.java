package com._hr.humanR.service;

import com._hr.humanR.entity.JobsEntity;

import java.util.List;

public interface JobService {
    List<JobsEntity> getJobs();
    JobsEntity saveJob(JobsEntity job);
    JobsEntity getJob(String id);
    void deleteJob(String id);
    List<JobsEntity> getMaxTenThousand(Integer salary);
}
