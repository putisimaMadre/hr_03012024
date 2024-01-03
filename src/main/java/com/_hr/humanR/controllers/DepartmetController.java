package com._hr.humanR.controllers;

import com._hr.humanR.entity.DepartmentsEntity;
import com._hr.humanR.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmetController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/departments")
    public List<DepartmentsEntity> getDepartment(){
        return departmentService.getDepartments();
    }
}
