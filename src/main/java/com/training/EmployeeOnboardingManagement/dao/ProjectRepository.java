package com.training.EmployeeOnboardingManagement.dao;

import com.training.EmployeeOnboardingManagement.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {
}
