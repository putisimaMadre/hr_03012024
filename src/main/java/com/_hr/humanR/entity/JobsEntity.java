package com._hr.humanR.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "jobs", schema = "hr", catalog = "")
public class JobsEntity {
    @Id
    @Column(name = "job_id")
    private String jobId;
    @Basic
    @Column(name = "job_title")
    private String jobTitle;
    @Basic
    @Column(name = "min_salary")
    private Integer minSalary;
    @Basic
    @Column(name = "max_salary")
    private Integer maxSalary;
    @OneToMany(mappedBy = "job")
    //@JsonManagedReference
    @JsonIgnore
    private List<EmployeesEntity> employeesByJobId;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

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

    public List<EmployeesEntity> getEmployeesByJobId() {
        return employeesByJobId;
    }

    public void setEmployeesByJobId(List<EmployeesEntity> employeesByJobId) {
        this.employeesByJobId = employeesByJobId;
    }
}
