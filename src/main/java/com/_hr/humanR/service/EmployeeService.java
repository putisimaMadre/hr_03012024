package com._hr.humanR.service;

import com._hr.humanR.entity.EmployeesEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeesEntity> getEmployees();
    EmployeesEntity saveEmployee(EmployeesEntity employee);
    EmployeesEntity getEmployee(Long id);
    void deleteEmployee(Long id);
}
