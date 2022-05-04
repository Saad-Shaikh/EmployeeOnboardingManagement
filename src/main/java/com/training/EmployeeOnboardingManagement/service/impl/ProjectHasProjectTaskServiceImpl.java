package com.training.EmployeeOnboardingManagement.service.impl;

import com.training.EmployeeOnboardingManagement.dao.ProjectHasProjectTaskRepository;
import com.training.EmployeeOnboardingManagement.dto.ProjectTaskUpdateDTO;
import com.training.EmployeeOnboardingManagement.entity.ProjectEntity;
import com.training.EmployeeOnboardingManagement.entity.ProjectHasProjectTaskEntity;
import com.training.EmployeeOnboardingManagement.entity.TaskEntity;
import com.training.EmployeeOnboardingManagement.enums.ErrorMessage;
import com.training.EmployeeOnboardingManagement.enums.TaskStatus;
import com.training.EmployeeOnboardingManagement.enums.TaskType;
import com.training.EmployeeOnboardingManagement.exception.ErrorMessagePayload;
import com.training.EmployeeOnboardingManagement.exception.NotFoundException;
import com.training.EmployeeOnboardingManagement.mapper.ProjectHasProjectTaskMapper;
import com.training.EmployeeOnboardingManagement.service.ProjectHasProjectTaskService;
import com.training.EmployeeOnboardingManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjectHasProjectTaskServiceImpl implements ProjectHasProjectTaskService {
    @Autowired
    private ProjectHasProjectTaskRepository projectHasProjectTaskRepository;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectHasProjectTaskMapper projectHasProjectTaskMapper;

    @Override
    public List<ProjectHasProjectTaskEntity> getTasksForProject(Integer id) {
        return projectHasProjectTaskRepository.findByProjectId(id);
    }

    @Override
    public List<ProjectHasProjectTaskEntity> addAllProjectTasksToProject(ProjectEntity project) {
        List<TaskEntity> projectTasks = taskService.findByTaskType(TaskType.PROJECT);
        List<ProjectHasProjectTaskEntity> projectHasProjectTaskList = new ArrayList<>();
        for (TaskEntity prTask : projectTasks) {
            ProjectHasProjectTaskEntity projectHasProjectTask = new ProjectHasProjectTaskEntity(
                    project, prTask, "", null, null, "", TaskStatus.ASSIGNED
            );
            projectHasProjectTaskList.add(projectHasProjectTask);
        }
        return projectHasProjectTaskRepository.saveAll(projectHasProjectTaskList);
    }

    @Override
    public void updateProjectTask(Integer projectTaskId, ProjectTaskUpdateDTO projectTaskUpdateDTO) {
        ProjectHasProjectTaskEntity projectTask = getById(projectTaskId);
        projectHasProjectTaskMapper.mapUpdateDTOToEntity(projectTaskUpdateDTO, projectTask);
    }

    private ProjectHasProjectTaskEntity getById(Integer id) {
        return projectHasProjectTaskRepository.findById(id).orElseThrow(
                () -> new NotFoundException(new ErrorMessagePayload(HttpStatus.NOT_FOUND, ErrorMessage.NOT_FOUND, "Project Task with id " + id + " does not exist"))
        );
    }
}
