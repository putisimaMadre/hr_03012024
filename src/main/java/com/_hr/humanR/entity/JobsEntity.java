package com._hr.humanR.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "jobs", schema = "hr", catalog = "")
public class JobsEntity {
    private String jobId;
    private String jobTitle;
    private Integer minSalary;
    private Integer maxSalary;
    private List<EmployeesEntity> employeesByJobId;

    @Id
    @Column(name = "job_id")
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "job_title")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "min_salary")
    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    @Basic
    @Column(name = "max_salary")
    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobsEntity that = (JobsEntity) o;
        return Objects.equals(jobId, that.jobId) && Objects.equals(jobTitle, that.jobTitle) && Objects.equals(minSalary, that.minSalary) && Objects.equals(maxSalary, that.maxSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, jobTitle, minSalary, maxSalary);
    }

    @OneToMany(mappedBy = "jobs")
    //@JsonBackReference
    @JsonIgnore
    public List<EmployeesEntity> getEmployeesByJobId() {
        return employeesByJobId;
    }

    public void setEmployeesByJobId(List<EmployeesEntity> employeesByJobId) {
        this.employeesByJobId = employeesByJobId;
    }
}
