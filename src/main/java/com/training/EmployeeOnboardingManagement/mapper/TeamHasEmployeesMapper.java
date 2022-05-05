package com.training.EmployeeOnboardingManagement.mapper;

import com.training.EmployeeOnboardingManagement.dto.TeamHasEmployeesListDTO;
import com.training.EmployeeOnboardingManagement.entity.TeamHasEmployeesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = EmployeeMapper.class)
public interface TeamHasEmployeesMapper {
    @Mapping(target = "employeeListDTO", source = "employee")
    TeamHasEmployeesListDTO mapEntityToListDTO(TeamHasEmployeesEntity teamHasEmployees);
    List<TeamHasEmployeesListDTO> mapEntityListToListDTOList(List<TeamHasEmployeesEntity> teamHasEmployeesEntities);
}
