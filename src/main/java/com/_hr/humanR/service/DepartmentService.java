package com._hr.humanR.service;

import com._hr.humanR.entity.DepartmentsEntity;

import java.util.List;

public interface DepartmentService {
    List<DepartmentsEntity> getDepartments();
    DepartmentsEntity getDepartment(Long id);
    DepartmentsEntity saveDepartment(DepartmentsEntity department);
    void deleteDepartment(Long id);
}
