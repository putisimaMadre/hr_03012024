package com._hr.humanR.controllers;

import com._hr.humanR.entity.DepartmentsEntity;
import com._hr.humanR.entity.EmployeesEntity;
import com._hr.humanR.entity.JobsEntity;
import com._hr.humanR.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employees")
    public List<EmployeesEntity> getEmployee(){
        return employeeService.getEmployees();
    }

    @PostMapping("/employees")
    public EmployeesEntity saveEmployee(@RequestBody EmployeesEntity employee){
        JobsEntity job = new JobsEntity();
        job.setJobId("AC_MGR");
        DepartmentsEntity department = new DepartmentsEntity();
        department.setDepartmentId(10);
        employee.setJobs(job);
        employee.setDepartments(department);
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public EmployeesEntity getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public EmployeesEntity updateJob(@RequestBody EmployeesEntity employee, @PathVariable Long id){
        EmployeesEntity employeesEntityActual = employeeService.getEmployee(id);
        employeesEntityActual.setFirstName(employee.getFirstName());
        employeesEntityActual.setLastName(employee.getLastName());
        employeesEntityActual.setEmail(employee.getEmail());
        employeesEntityActual.setSalary(employee.getSalary());
        employeesEntityActual.setManagerId(employee.getManagerId());

        JobsEntity jobU = new JobsEntity();
        jobU.setJobId("MK_REP");
        DepartmentsEntity department = new DepartmentsEntity();
        department.setDepartmentId(40);
        employeesEntityActual.setJobs(jobU);
        employeesEntityActual.setDepartments(department);
        return employeeService.saveEmployee(employeesEntityActual);
    }

    @DeleteMapping("/employees/{id}")
    public void deteleEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}
