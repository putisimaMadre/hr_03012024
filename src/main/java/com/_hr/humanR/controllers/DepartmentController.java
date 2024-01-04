package com._hr.humanR.controllers;

import com._hr.humanR.entity.DepartmentsEntity;
import com._hr.humanR.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/departments")
    public List<DepartmentsEntity> getDepartments(){
        return departmentService.getDepartments();
    }
    @PostMapping("/departments")
    public DepartmentsEntity saveDepartment(@RequestBody DepartmentsEntity department){
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments/{id}")
        public DepartmentsEntity getDepartment(@PathVariable Long id){
        return departmentService.getDepartment(id);
    }

    @PutMapping("/departments/{id}")
    public DepartmentsEntity updateDepartment(@RequestBody DepartmentsEntity department, @PathVariable Long id){
        DepartmentsEntity departmentsEntityActual = departmentService.getDepartment(id);
        departmentsEntityActual.setManagerId(department.getManagerId());
        departmentsEntityActual.setDepartmentName(department.getDepartmentName());
        departmentsEntityActual.setLocationId(department.getLocationId());
        return departmentService.saveDepartment(departmentsEntityActual);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }
}
