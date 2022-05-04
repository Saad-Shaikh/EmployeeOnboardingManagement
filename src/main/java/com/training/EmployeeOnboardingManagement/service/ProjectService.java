package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dto.*;

public interface ProjectService {
    ProjectAndProjectTasksDTO getEmployeeProjectAndTasks(Integer id);
    ProjectAndProjectTasksDTO addProjectForEmployee(Integer id, ProjectCreateDTO projectCreateDTO);
    ProjectAndProjectTasksDTO updateProjectForEmployee(Integer id, ProjectUpdateDTO projectUpdateDTO);
    ProjectAndProjectTasksDTO updateEmployeeProjectTask(Integer id, Integer projectTaskId, ProjectTaskUpdateDTO projectTaskUpdateDTO);
}
