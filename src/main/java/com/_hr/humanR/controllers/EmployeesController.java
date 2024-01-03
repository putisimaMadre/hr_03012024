package com._hr.humanR.controllers;

import com._hr.humanR.entity.EmployeesEntity;
import com._hr.humanR.entity.JobsEntity;
import com._hr.humanR.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeesController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employees")
    public List<EmployeesEntity> getEmployees(){
        return employeeService.getEmployee();
    }

    @GetMapping("/employees/{id}")
    public EmployeesEntity getEmployee(@PathVariable long id){
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeesEntity saveEmployee(@RequestBody EmployeesEntity employee){
        //EmployeesEntity employeeS = new EmployeesEntity();
        /*employee.getDepartment().setDepartmentId(10);
        employee.set
        employee.getDepartment().setManagerId(200);
        employee.getJob().setJobId("AD VP");*/
        //System.out.println(employee);
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public EmployeesEntity updateJob(@RequestBody EmployeesEntity employee, @PathVariable Long id){
        EmployeesEntity employeesEntityActual =  employeeService.getEmployee(id);
        employeesEntityActual.setFirstName(employee.getFirstName());
        employeesEntityActual.setLastName(employee.getLastName());
        employeesEntityActual.setEmail(employee.getEmail());
        //employeesEntityActual.setJobsByJobId(employee.getJobsByJobId());
        employeesEntityActual.setSalary(employee.getSalary());
        //employeesEntityActual.setManagerId(employee.getManagerId());
        //employeesEntityActual.setDepartmentsByDepartmentId (employee.getDepartmentsByDepartmentId());
        return employeeService.saveEmployee(employeesEntityActual);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteJob(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}
