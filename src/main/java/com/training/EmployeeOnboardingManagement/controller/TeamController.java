package com.training.EmployeeOnboardingManagement.controller;

import com.training.EmployeeOnboardingManagement.dto.TeamCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.TeamNameDTO;
import com.training.EmployeeOnboardingManagement.dto.TeamUpdateDTO;
import com.training.EmployeeOnboardingManagement.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/teams")
public class TeamController {
    private final TeamService teamService;

    @GetMapping()
    public List<TeamNameDTO> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping()
    public TeamNameDTO createTeam(@RequestBody @Valid TeamCreateDTO teamCreateDTO) {
        return teamService.createTeam(teamCreateDTO);
    }

    @GetMapping(path = "{id}")
    public TeamNameDTO getTeamById(@PathVariable("id") Integer id) {
        return teamService.getTeamById(id);
    }

    @PatchMapping(path = "{id}")
    public TeamNameDTO updateTeamName(@PathVariable("id") Integer id, @RequestBody @Valid TeamUpdateDTO teamUpdateDTO) {
        return teamService.updateTeamName(id, teamUpdateDTO);
    }
}
