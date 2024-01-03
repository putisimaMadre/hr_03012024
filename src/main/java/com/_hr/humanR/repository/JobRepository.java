package com._hr.humanR.repository;

import com._hr.humanR.entity.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobsEntity, String> {

    @Query("SELECT b FROM JobsEntity b WHERE b.maxSalary < :salary")
    List<JobsEntity> findTenThousand(@Param("salary") Integer salary);
}
