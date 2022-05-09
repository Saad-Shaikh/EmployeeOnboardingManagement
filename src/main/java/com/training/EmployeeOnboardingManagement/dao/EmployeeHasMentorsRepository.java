package com.training.EmployeeOnboardingManagement.dao;

import com.training.EmployeeOnboardingManagement.entity.EmployeeHasMentorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeHasMentorsRepository extends JpaRepository<EmployeeHasMentorsEntity, Integer> {
    @Query(value = "SELECT * FROM EMPLOYEE_HAS_MENTORS e WHERE e.employee_id = ?1", nativeQuery = true)
    List<EmployeeHasMentorsEntity> findAllByEmployeeId(Integer id);
}
