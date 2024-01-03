package com._hr.humanR.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "departments", schema = "hr", catalog = "")
public class DepartmentsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "department_id")
    private Integer departmentId;
    @Basic
    @Column(name = "department_name")
    private String departmentName;
    @Basic
    @Column(name = "manager_id")
    private Integer managerId;
    @Basic
    @Column(name = "location_id")
    private Integer locationId;
    @OneToMany(mappedBy = "department")
    //@JsonManagedReference
    @JsonIgnore
    private List<EmployeesEntity> employeesByDepartmentId;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentsEntity that = (DepartmentsEntity) o;
        return Objects.equals(departmentId, that.departmentId) && Objects.equals(departmentName, that.departmentName) && Objects.equals(managerId, that.managerId) && Objects.equals(locationId, that.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName, managerId, locationId);
    }

    public List<EmployeesEntity> getEmployeesByDepartmentId() {
        return employeesByDepartmentId;
    }

    public void setEmployeesByDepartmentId(List<EmployeesEntity> employeesByDepartmentId) {
        this.employeesByDepartmentId = employeesByDepartmentId;
    }
}
