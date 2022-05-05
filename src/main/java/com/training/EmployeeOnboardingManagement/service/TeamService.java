package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dto.TeamCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.TeamNameDTO;
import com.training.EmployeeOnboardingManagement.dto.TeamUpdateDTO;

import java.util.List;

public interface TeamService {
    List<TeamNameDTO> getAllTeams();

    TeamNameDTO createTeam(TeamCreateDTO teamCreateDTO);

    TeamNameDTO getTeamById(Integer id);

    TeamNameDTO updateTeamName(Integer id, TeamUpdateDTO teamUpdateDTO);
}
