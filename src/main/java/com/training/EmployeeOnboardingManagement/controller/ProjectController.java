package com.training.EmployeeOnboardingManagement.controller;

import com.training.EmployeeOnboardingManagement.dto.*;
import com.training.EmployeeOnboardingManagement.entity.ProjectEntity;
import com.training.EmployeeOnboardingManagement.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/employees/{id}/project")
@AllArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping()
    public ProjectAndProjectTasksDTO getEmployeeProject(@PathVariable("id") Integer id) {
        return projectService.getEmployeeProjectAndTasks(id);
    }

    @PostMapping()
    public ProjectAndProjectTasksDTO addProjectForEmployee(@PathVariable("id") Integer id, @RequestBody ProjectCreateDTO projectCreateDTO) {
        return projectService.addProjectForEmployee(id, projectCreateDTO);
    }

    @PutMapping()
    public ProjectAndProjectTasksDTO updateEmployeeProject(@PathVariable("id") Integer id, @RequestBody ProjectUpdateDTO projectUpdateDTO) {
        return projectService.updateProjectForEmployee(id, projectUpdateDTO);
    }

    @PutMapping(path = "{projectTaskId}")
    public ProjectAndProjectTasksDTO updateEmployeeProjectTask(@PathVariable("id") Integer id, @PathVariable("projectTaskId") Integer projectTaskId, @RequestBody ProjectTaskUpdateDTO projectTaskUpdateDTO) {
        return projectService.updateEmployeeProjectTask(id, projectTaskId, projectTaskUpdateDTO);
    }
}
