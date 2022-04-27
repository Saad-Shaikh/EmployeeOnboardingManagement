package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dao.ProjectHasProjectTaskRepository;
import com.training.EmployeeOnboardingManagement.entity.ProjectEntity;
import com.training.EmployeeOnboardingManagement.entity.ProjectHasProjectTaskEntity;
import com.training.EmployeeOnboardingManagement.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectHasProjectTaskServiceImpl implements ProjectHasProjectTaskService {
    @Autowired
    private ProjectHasProjectTaskRepository projectHasProjectTaskRepository;

    @Override
    public void addAllTasksToProject(ProjectEntity savedProject, List<TaskEntity> projectTasks) {
        for (TaskEntity prTask :
                projectTasks) {
            ProjectHasProjectTaskEntity projectHasProjectTask = new ProjectHasProjectTaskEntity(
                    savedProject, prTask, "", null, null, "", ""
            );
            projectHasProjectTaskRepository.save(projectHasProjectTask);
        }
    }

    @Override
    public List<ProjectHasProjectTaskEntity> getTasksForProject(Integer id) {
        return projectHasProjectTaskRepository.findProjectTasksByProjectId(id);
    }
}
