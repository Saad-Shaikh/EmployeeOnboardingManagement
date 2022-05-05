package com.training.EmployeeOnboardingManagement.dao;

import com.training.EmployeeOnboardingManagement.entity.TeamHasEmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamHasEmployeesRepository extends JpaRepository<TeamHasEmployeesEntity, Integer> {
    List<TeamHasEmployeesEntity> findByTeamId(Integer id);
}
