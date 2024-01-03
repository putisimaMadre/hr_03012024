package com._hr.humanR.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "employees", schema = "hr", catalog = "")
public class EmployeesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employee_id", insertable=false, updatable=false)
    private Integer employeeId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "salary")
    private Integer salary;
    @Basic
    @Column(name = "manager_id")
    private Integer managerId;
    @Basic
    @Column(name = "department_id", insertable=false, updatable=false)
    private Integer departmentId;
    @Basic
    @Column(name = "job_id", insertable=false, updatable=false)
    private String jobId;
    @ManyToOne
    //@JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false)
    private DepartmentsEntity departmentsByDepartmentId;
    @ManyToOne
    //@JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "job_id", referencedColumnName = "job_id", nullable = false)
    private JobsEntity jobsByJobId;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesEntity that = (EmployeesEntity) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && Objects.equals(salary, that.salary) && Objects.equals(managerId, that.managerId) && Objects.equals(departmentId, that.departmentId) && Objects.equals(jobId, that.jobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, email, salary, managerId, departmentId, jobId);
    }

    public DepartmentsEntity getDepartmentsByDepartmentId() {
        return departmentsByDepartmentId;
    }

    public void setDepartmentsByDepartmentId(DepartmentsEntity departmentsByDepartmentId) {
        this.departmentsByDepartmentId = departmentsByDepartmentId;
    }

    public JobsEntity getJobsByJobId() {
        return jobsByJobId;
    }

    public void setJobsByJobId(JobsEntity jobsByJobId) {
        this.jobsByJobId = jobsByJobId;
    }
}
