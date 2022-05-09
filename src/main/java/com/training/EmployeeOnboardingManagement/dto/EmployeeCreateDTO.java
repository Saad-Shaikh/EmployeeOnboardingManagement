package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.Designation;
import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
public class EmployeeCreateDTO {
    @NotNull()
    private String name;

    @NotNull()
    private LocalDate dob;

    @NotNull()
    private String address;

    @NotNull()
    private String phone;

    @NotNull()
    private Designation designation;

    @NotNull()
    private LocalDate onboardingStartDate;

    @NotNull()
    private LocalDate onboardingEndDate;

    @NotNull()
    private Set<EmployeeListDTO> mentoredBy;

    @NotNull()
    private EmployeeStatus status;
}
