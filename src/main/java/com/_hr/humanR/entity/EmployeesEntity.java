package com._hr.humanR.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "employees", schema = "hr", catalog = "")
public class EmployeesEntity {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer salary;
    private Integer managerId;
    private DepartmentsEntity departments;
    private JobsEntity jobs;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employee_id")
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "salary")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "manager_id")
    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesEntity employees = (EmployeesEntity) o;
        return Objects.equals(employeeId, employees.employeeId) && Objects.equals(firstName, employees.firstName) && Objects.equals(lastName, employees.lastName) && Objects.equals(email, employees.email) && Objects.equals(salary, employees.salary) && Objects.equals(managerId, employees.managerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, email, salary, managerId);
    }

    @ManyToOne
    //@JsonManagedReference
    @JsonIgnore
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false)
    public DepartmentsEntity getDepartments() {
        return departments;
    }

    public void setDepartments(DepartmentsEntity departments) {
        this.departments = departments;
    }

    @ManyToOne
    //@JsonManagedReference
    @JsonIgnore
    @JoinColumn(name = "job_id", referencedColumnName = "job_id", nullable = false)
    public JobsEntity getJobs() {
        return jobs;
    }

    public void setJobs(JobsEntity jobs) {
        this.jobs = jobs;
    }
}
