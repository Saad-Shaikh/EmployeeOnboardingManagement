package com.training.EmployeeOnboardingManagement.dao;

import com.training.EmployeeOnboardingManagement.entity.ProjectHasProjectTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectHasProjectTaskRepository extends JpaRepository<ProjectHasProjectTaskEntity, Integer> {
    @Query("SELECT p FROM PROJECT_HAS_PROJECT_TASK p WHERE p.ref_project_id = ?1")
    List<ProjectHasProjectTaskEntity> findProjectTasksByProjectId(Integer id);
}
