package com._hr.humanR.repository;

import com._hr.humanR.entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeesEntity, Long> {
}
