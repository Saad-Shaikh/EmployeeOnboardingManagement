package com.training.EmployeeOnboardingManagement.service.impl;

import com.training.EmployeeOnboardingManagement.dao.ProjectRepository;
import com.training.EmployeeOnboardingManagement.dto.*;
import com.training.EmployeeOnboardingManagement.entity.ProjectEntity;
import com.training.EmployeeOnboardingManagement.entity.ProjectHasProjectTaskEntity;
import com.training.EmployeeOnboardingManagement.enums.ErrorMessage;
import com.training.EmployeeOnboardingManagement.exception.ErrorMessagePayload;
import com.training.EmployeeOnboardingManagement.exception.NotFoundException;
import com.training.EmployeeOnboardingManagement.mapper.ProjectMapper;
import com.training.EmployeeOnboardingManagement.service.EmployeeService;
import com.training.EmployeeOnboardingManagement.service.ProjectHasProjectTaskService;
import com.training.EmployeeOnboardingManagement.service.ProjectService;
import com.training.EmployeeOnboardingManagement.validator.ProjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectHasProjectTaskService projectHasProjectTaskService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ProjectValidator projectValidator;

    @Override
    public ProjectAndProjectTasksDTO getEmployeeProjectAndTasks(Integer id) {
        ProjectEntity project = getProjectForEmployee(id);
        List<ProjectHasProjectTaskEntity> projectTasks = getTasksForProject(project);
        return projectMapper.mapEntityToProjectAndProjectTasksDTO(project, projectTasks);
    }

    @Override
    public ProjectAndProjectTasksDTO addProjectForEmployee(Integer id, ProjectCreateDTO projectCreateDTO) {
        projectValidator.validate(projectCreateDTO);
        ProjectEntity project = projectMapper.mapCreateDTOToEntity(projectCreateDTO);
        projectRepository.save(project);
        employeeService.addProjectForEmployee(id, project);
        List<ProjectHasProjectTaskEntity> projectHasProjectTaskList = projectHasProjectTaskService.addAllProjectTasksToProject(project);
        return projectMapper.mapEntityToProjectAndProjectTasksDTO(project, projectHasProjectTaskList);
    }

    @Override
    public ProjectAndProjectTasksDTO updateProjectForEmployee(Integer id, ProjectUpdateDTO projectUpdateDTO) {
        projectValidator.validate(projectUpdateDTO);
        ProjectEntity project = getProjectForEmployee(id);
        projectMapper.mapUpdateDTOToEntity(projectUpdateDTO, project);
        List<ProjectHasProjectTaskEntity> projectTasks = getTasksForProject(project);
        return projectMapper.mapEntityToProjectAndProjectTasksDTO(project, projectTasks);
    }

    @Override
    public ProjectAndProjectTasksDTO updateEmployeeProjectTask(Integer id, Integer projectTaskId, ProjectTaskUpdateDTO projectTaskUpdateDTO) {
        projectValidator.validate(projectTaskUpdateDTO);
        ProjectEntity project = getProjectForEmployee(id);
        projectHasProjectTaskService.updateProjectTask(projectTaskId, projectTaskUpdateDTO);
        List<ProjectHasProjectTaskEntity> projectTasks = getTasksForProject(project);
        return projectMapper.mapEntityToProjectAndProjectTasksDTO(project, projectTasks);
    }

    private ProjectEntity getProjectForEmployee(Integer id) {
        return projectRepository.findByEmployeeId(id).orElseThrow(
                () -> new NotFoundException(new ErrorMessagePayload(HttpStatus.NOT_FOUND, ErrorMessage.NOT_FOUND, "Project for Employee with id " + id + " does not exist!"))
        );
    }

    private List<ProjectHasProjectTaskEntity> getTasksForProject(ProjectEntity project) {
        return projectHasProjectTaskService.getTasksForProject(project.getId());
    }
}
