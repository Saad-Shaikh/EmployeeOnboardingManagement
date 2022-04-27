package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class EmployeeDTO {
    private Integer id;
    private String name;
    private Date dob;
    private String address;
    private String phone;
    private String designation;
    private Date onboardingStartDate;
    private Date onboardingEndDate;
    private String status;

    public static EmployeeDTO EmployeeToEmployeeDTO(EmployeeEntity employee) {
        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getDob(), employee.getAddress(), employee.getPhone(), employee.getDesignation(), employee.getOnboardingStartDate(), employee.getOnboardingEndDate(), employee.getStatus());
    }

    public static EmployeeEntity EmployeeDTOToEmployee(EmployeeDTO employeeDTO) {
        return new EmployeeEntity(employeeDTO.getId(), employeeDTO.getName(), employeeDTO.getDob(), employeeDTO.getAddress(), employeeDTO.getPhone(), employeeDTO.getDesignation(), employeeDTO.getOnboardingStartDate(), employeeDTO.getOnboardingEndDate(), employeeDTO.getStatus());
    }
}
