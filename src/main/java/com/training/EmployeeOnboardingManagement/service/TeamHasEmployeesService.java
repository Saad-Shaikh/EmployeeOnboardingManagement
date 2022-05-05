package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dto.EmployeeListDTO;
import com.training.EmployeeOnboardingManagement.dto.TeamHasEmployeesListDTO;

import java.util.List;

public interface TeamHasEmployeesService {
    List<TeamHasEmployeesListDTO> getMembersForTeam(Integer id);

    void addMemberToTeam(Integer id, EmployeeListDTO employeeListDTO);

    void removeAllMembersFromTeam(Integer id);

    void removeMemberFromTeam(Integer id, Integer employeeId);
}
