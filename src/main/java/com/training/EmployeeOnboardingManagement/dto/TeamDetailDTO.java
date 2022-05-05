package com.training.EmployeeOnboardingManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
public class TeamDetailDTO {
    private Integer id;
    private String name;
    private Set<TeamHasEmployeesDetailDTO> teamHasEmployeesSet;
}
