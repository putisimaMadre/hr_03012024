package com._hr.humanR.service;

import com._hr.humanR.entity.EmployeesEntity;
import com._hr.humanR.entity.JobsEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeesEntity> getEmployee();
    EmployeesEntity saveEmployee(EmployeesEntity employee);
    EmployeesEntity getEmployee(Long id);
    void deleteEmployee(Long id);

    //List<JobsEntity> getMaxTenThousand(Integer salary);
}
