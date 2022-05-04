package com.training.EmployeeOnboardingManagement.mapper;

import com.training.EmployeeOnboardingManagement.dto.OnboardingTaskDetailDTO;
import com.training.EmployeeOnboardingManagement.dto.OnboardingTaskUpdateDTO;
import com.training.EmployeeOnboardingManagement.entity.EmployeeHasOnboardingTaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeHasOnboardingTaskMapper {
    List<OnboardingTaskDetailDTO> mapEntityListToDetailDTOList(List<EmployeeHasOnboardingTaskEntity> employeeHasOnboardingTaskEntityList);
    void mapUpdateDTOToEntity (OnboardingTaskUpdateDTO onboardingTaskUpdateDTO, @MappingTarget EmployeeHasOnboardingTaskEntity employeeHasOnboardingTask);
}
