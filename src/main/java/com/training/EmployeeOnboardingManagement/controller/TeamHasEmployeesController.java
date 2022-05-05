package com.training.EmployeeOnboardingManagement.controller;

import com.training.EmployeeOnboardingManagement.dto.EmployeeListDTO;
import com.training.EmployeeOnboardingManagement.dto.TeamHasEmployeesListDTO;
import com.training.EmployeeOnboardingManagement.service.TeamHasEmployeesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/teams/{id}/members")
public class TeamHasEmployeesController {
    private final TeamHasEmployeesService teamHasEmployeesService;

    @GetMapping
    public List<TeamHasEmployeesListDTO> getMembersForTeam(@PathVariable("id") Integer id) {
        return teamHasEmployeesService.getMembersForTeam(id);
    }

    @PostMapping
    public List<TeamHasEmployeesListDTO> addMemberToTeam(@PathVariable("id") Integer id, @RequestBody @Valid EmployeeListDTO employeeListDTO) {
        teamHasEmployeesService.addMemberToTeam(id, employeeListDTO);
        return teamHasEmployeesService.getMembersForTeam(id);
    }

    @DeleteMapping
    public List<TeamHasEmployeesListDTO> removeAllMembersFromTeam(@PathVariable("id") Integer id) {
        teamHasEmployeesService.removeAllMembersFromTeam(id);
        return teamHasEmployeesService.getMembersForTeam(id);
    }

    @DeleteMapping(path = "{employeeId}")
    public List<TeamHasEmployeesListDTO> removeMemberFromTeam(@PathVariable("id") Integer id, @PathVariable("employeeId") Integer employeeId) {
        teamHasEmployeesService.removeMemberFromTeam(id, employeeId);
        return teamHasEmployeesService.getMembersForTeam(id);
    }
}
