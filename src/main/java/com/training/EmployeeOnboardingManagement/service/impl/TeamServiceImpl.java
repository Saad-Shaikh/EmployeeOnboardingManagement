package com.training.EmployeeOnboardingManagement.service.impl;

import com.training.EmployeeOnboardingManagement.dao.TeamRepository;
import com.training.EmployeeOnboardingManagement.dto.TeamCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.TeamNameDTO;
import com.training.EmployeeOnboardingManagement.dto.TeamUpdateDTO;
import com.training.EmployeeOnboardingManagement.entity.TeamEntity;
import com.training.EmployeeOnboardingManagement.enums.ErrorMessage;
import com.training.EmployeeOnboardingManagement.exception.ErrorMessagePayload;
import com.training.EmployeeOnboardingManagement.exception.NotFoundException;
import com.training.EmployeeOnboardingManagement.mapper.TeamMapper;
import com.training.EmployeeOnboardingManagement.service.TeamService;
import com.training.EmployeeOnboardingManagement.validator.TeamValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private TeamValidator teamValidator;

    @Override
    public List<TeamNameDTO> getAllTeams() {
        return teamMapper.mapEntityListToNameDTOList(teamRepository.findAll());
    }

    @Override
    public TeamNameDTO createTeam(TeamCreateDTO teamCreateDTO) {
        teamValidator.validate(teamCreateDTO);
        TeamEntity team = teamMapper.mapCreateDTOToEntity(teamCreateDTO);
        return teamMapper.mapEntityToNameDTO(teamRepository.save(team));
    }

    @Override
    public TeamNameDTO getTeamById(Integer id) {
        return teamMapper.mapEntityToNameDTO(getById(id));
    }

    @Override
    public TeamNameDTO updateTeamName(Integer id, TeamUpdateDTO teamUpdateDTO) {
        TeamEntity team = getById(id);
        teamMapper.mapUpdateDTOToEntity(teamUpdateDTO, team);
        return teamMapper.mapEntityToNameDTO(team);
    }

    @Override
    public TeamEntity getById(Integer id) {
        return teamRepository.findById(id).orElseThrow(
                () -> new NotFoundException(new ErrorMessagePayload(HttpStatus.NOT_FOUND, ErrorMessage.NOT_FOUND, "Team with id " + id + " does not exist"))
        );
    }
}
