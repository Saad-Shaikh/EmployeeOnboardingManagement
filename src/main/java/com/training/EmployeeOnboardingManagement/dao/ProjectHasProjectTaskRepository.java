package com.training.EmployeeOnboardingManagement.dao;

import com.training.EmployeeOnboardingManagement.entity.ProjectHasProjectTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectHasProjectTaskRepository extends JpaRepository<ProjectHasProjectTaskEntity, Integer> {
    List<ProjectHasProjectTaskEntity> findByProjectId(Integer id);
}
