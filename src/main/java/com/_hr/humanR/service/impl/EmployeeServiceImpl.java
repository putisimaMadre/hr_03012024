package com._hr.humanR.service.impl;

import com._hr.humanR.entity.EmployeesEntity;
import com._hr.humanR.repository.EmployeeRepository;
import com._hr.humanR.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<EmployeesEntity> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeesEntity saveEmployee(EmployeesEntity employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeesEntity getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
