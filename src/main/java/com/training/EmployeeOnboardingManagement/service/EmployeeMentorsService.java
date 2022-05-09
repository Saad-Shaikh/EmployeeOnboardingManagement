package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.entity.EmployeeHasMentorsEntity;

import java.util.List;

public interface EmployeeMentorsService {
    List<EmployeeHasMentorsEntity> findAllByEmployeeId(Integer id);
}
