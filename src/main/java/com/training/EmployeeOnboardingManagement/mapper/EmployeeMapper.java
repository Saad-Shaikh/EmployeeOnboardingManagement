package com.training.EmployeeOnboardingManagement.mapper;

import com.training.EmployeeOnboardingManagement.dto.CreateEmployeeDTO;
import com.training.EmployeeOnboardingManagement.dto.DetailedEmployeeDTO;
import com.training.EmployeeOnboardingManagement.entity.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
    CreateEmployeeDTO EmployeeToCreateEmployeeDTO(EmployeeEntity employee);
    EmployeeEntity CreateEmployeeDTOToEmployee(CreateEmployeeDTO employeeDTO);
    DetailedEmployeeDTO EmployeeToDetailedEmployeeDTO(EmployeeEntity employee);
    EmployeeEntity DetailedEmployeeDTOToEmployee(DetailedEmployeeDTO employeeDTO);
}
