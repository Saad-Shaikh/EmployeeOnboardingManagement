package com.training.EmployeeOnboardingManagement.dao;

import com.training.EmployeeOnboardingManagement.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends JpaRepository<TaskEntity, Integer> {
}
