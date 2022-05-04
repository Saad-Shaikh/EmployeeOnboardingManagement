package com.training.EmployeeOnboardingManagement.dao;

import com.training.EmployeeOnboardingManagement.entity.EmployeeHasOnboardingTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeHasOnboardingTaskRepository extends JpaRepository<EmployeeHasOnboardingTaskEntity, Integer> {
    List<EmployeeHasOnboardingTaskEntity> findByEmployeeId(Integer id);
}
