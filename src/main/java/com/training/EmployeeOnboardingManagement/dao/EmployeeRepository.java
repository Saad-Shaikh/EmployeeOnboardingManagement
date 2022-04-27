package com.training.EmployeeOnboardingManagement.dao;

import com.training.EmployeeOnboardingManagement.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
