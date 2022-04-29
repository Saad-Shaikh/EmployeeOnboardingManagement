package com.training.EmployeeOnboardingManagement.mapper;

import com.training.EmployeeOnboardingManagement.dto.EmployeeCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.EmployeeDetailDTO;
import com.training.EmployeeOnboardingManagement.dto.EmployeeStatusPatchDTO;
import com.training.EmployeeOnboardingManagement.dto.EmployeeUpdateDTO;
import com.training.EmployeeOnboardingManagement.entity.EmployeeEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "mentoredBy", ignore = true)
    @Mapping(target = "mentorOf", ignore = true)
    @Mapping(target = "project", ignore = true)
    EmployeeEntity mapCreateDTOToEntity(EmployeeCreateDTO employeeDTO);

    EmployeeDetailDTO mapEntityToDetailDTO(EmployeeEntity employee);

    @Mapping(target = "mentorOf", ignore = true)
    @Mapping(target = "project", ignore = true)
    EmployeeEntity mapDetailDTOToEntity(EmployeeDetailDTO employeeDTO);

    List<EmployeeDetailDTO> mapEntityListToDetailDTOList(List<EmployeeEntity> employees);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "onboardingStartDate", ignore = true)
    @Mapping(target = "mentoredBy", ignore = true)
    @Mapping(target = "mentorOf", ignore = true)
    @Mapping(target = "project", ignore = true)
    @Mapping(target = "status", ignore = true)
    void mapUpdateDTOToEntity(EmployeeUpdateDTO employeeDTO, @MappingTarget EmployeeEntity employee);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "dob", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "designation", ignore = true)
    @Mapping(target = "onboardingStartDate", ignore = true)
    @Mapping(target = "onboardingEndDate", ignore = true)
    @Mapping(target = "mentoredBy", ignore = true)
    @Mapping(target = "mentorOf", ignore = true)
    @Mapping(target = "project", ignore = true)
    void mapStatusPatchDTOToEntity(EmployeeStatusPatchDTO employeeDTO, @MappingTarget EmployeeEntity employee);
}
