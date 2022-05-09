package com.training.EmployeeOnboardingManagement.service.impl;

import com.training.EmployeeOnboardingManagement.dao.EmployeeHasMentorsRepository;
import com.training.EmployeeOnboardingManagement.entity.EmployeeHasMentorsEntity;
import com.training.EmployeeOnboardingManagement.service.EmployeeMentorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeMentorsServiceImpl implements EmployeeMentorsService {
    @Autowired
    private EmployeeHasMentorsRepository employeeHasMentorsRepository;

    @Override
    public List<EmployeeHasMentorsEntity> findAllByEmployeeId(Integer id) {
        return employeeHasMentorsRepository.findAllByEmployeeId(id);
    }
}
