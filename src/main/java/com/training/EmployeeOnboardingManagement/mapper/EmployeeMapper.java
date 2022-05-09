package com.training.EmployeeOnboardingManagement.mapper;

import com.training.EmployeeOnboardingManagement.dto.*;
import com.training.EmployeeOnboardingManagement.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "mentoredBy", ignore = true)
    @Mapping(target = "mentorOf", ignore = true)
    @Mapping(target = "project", ignore = true)
    EmployeeEntity mapCreateDTOToEntity(EmployeeCreateDTO employeeDTO);

    @Mapping(target = "mentors", ignore = true)
    EmployeeDetailDTO mapEntityToDetailDTO(EmployeeEntity employee);

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

    EmployeeListDTO mapEntityToListDTO(EmployeeEntity employee);

    List<EmployeeListDTO> mapEntityListToListDTOList(List<EmployeeEntity> employees);
}
