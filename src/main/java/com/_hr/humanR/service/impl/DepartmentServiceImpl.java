package com._hr.humanR.service.impl;

import com._hr.humanR.entity.DepartmentsEntity;
import com._hr.humanR.repository.DepartmentRepository;
import com._hr.humanR.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<DepartmentsEntity> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentsEntity getDepartment(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public DepartmentsEntity saveDepartment(DepartmentsEntity department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
