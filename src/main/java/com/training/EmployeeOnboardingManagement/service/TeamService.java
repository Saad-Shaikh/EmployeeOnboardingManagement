package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dto.TeamCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.TeamNameDTO;
import com.training.EmployeeOnboardingManagement.dto.TeamUpdateDTO;
import com.training.EmployeeOnboardingManagement.entity.TeamEntity;

import java.util.List;

public interface TeamService {
    TeamEntity getById(Integer id);
    List<TeamNameDTO> getAllTeams();

    TeamNameDTO createTeam(TeamCreateDTO teamCreateDTO);

    TeamNameDTO getTeamById(Integer id);

    TeamNameDTO updateTeamName(Integer id, TeamUpdateDTO teamUpdateDTO);
}
