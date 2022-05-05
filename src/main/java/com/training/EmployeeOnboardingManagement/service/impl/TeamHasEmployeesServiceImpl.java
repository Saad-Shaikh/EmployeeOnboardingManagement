package com.training.EmployeeOnboardingManagement.service.impl;

import com.training.EmployeeOnboardingManagement.dao.TeamHasEmployeesRepository;
import com.training.EmployeeOnboardingManagement.dto.EmployeeListDTO;
import com.training.EmployeeOnboardingManagement.dto.TeamHasEmployeesListDTO;
import com.training.EmployeeOnboardingManagement.entity.EmployeeEntity;
import com.training.EmployeeOnboardingManagement.entity.TeamEntity;
import com.training.EmployeeOnboardingManagement.entity.TeamHasEmployeesEntity;
import com.training.EmployeeOnboardingManagement.mapper.EmployeeMapper;
import com.training.EmployeeOnboardingManagement.mapper.TeamHasEmployeesMapper;
import com.training.EmployeeOnboardingManagement.service.EmployeeService;
import com.training.EmployeeOnboardingManagement.service.TeamHasEmployeesService;
import com.training.EmployeeOnboardingManagement.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TeamHasEmployeesServiceImpl implements TeamHasEmployeesService {
    @Autowired
    private TeamHasEmployeesRepository teamHasEmployeesRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private TeamHasEmployeesMapper teamHasEmployeesMapper;

    @Override
    public List<TeamHasEmployeesListDTO> getMembersForTeam(Integer id) {
        List<TeamHasEmployeesEntity> teamHasEmployeesEntities = teamHasEmployeesRepository.findByTeamId(id);
        teamHasEmployeesEntities.removeIf(teamHasEmployeesEntity -> teamHasEmployeesEntity.getEndDate() != null);
        return teamHasEmployeesMapper.mapEntityListToListDTOList(teamHasEmployeesEntities);
    }

    @Override
    public void addMemberToTeam(Integer id, EmployeeListDTO employeeListDTO) {
        TeamEntity team = teamService.getById(id);
        EmployeeEntity employee = employeeService.getById(employeeListDTO.getId());
        teamHasEmployeesRepository.save(
                new TeamHasEmployeesEntity(team, employee, LocalDate.now())
        );
    }

    @Override
    public void removeAllMembersFromTeam(Integer id) {
        List<TeamHasEmployeesEntity> teamHasEmployeesEntities = teamHasEmployeesRepository.findByTeamId(id);
        teamHasEmployeesEntities.forEach(
                teamHasEmployeesEntity -> {
                    if (teamHasEmployeesEntity.getEndDate() == null) {
                        teamHasEmployeesEntity.setEndDate(LocalDate.now());
                    }
                }
        );
    }

    @Override
    public void removeMemberFromTeam(Integer id, Integer employeeId) {
        List<TeamHasEmployeesEntity> teamHasEmployeesEntities = teamHasEmployeesRepository.findByTeamId(id);
        teamHasEmployeesEntities.forEach(
                teamHasEmployeesEntity -> {
                    if (teamHasEmployeesEntity.getEmployee().getId() == employeeId) {
                        teamHasEmployeesEntity.setEndDate(LocalDate.now());
                    }
                }
        );
    }
}
