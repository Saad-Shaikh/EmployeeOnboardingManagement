package com.training.EmployeeOnboardingManagement.dao;

import com.training.EmployeeOnboardingManagement.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Integer> {
}
