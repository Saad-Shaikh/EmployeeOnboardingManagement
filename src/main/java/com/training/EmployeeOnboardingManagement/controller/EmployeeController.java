package com.training.EmployeeOnboardingManagement.controller;

import com.training.EmployeeOnboardingManagement.dto.EmployeeDTO;
import com.training.EmployeeOnboardingManagement.dto.EmployeeStatusPatchDTO;
import com.training.EmployeeOnboardingManagement.dto.ProjectAndProjectTasksDTO;
import com.training.EmployeeOnboardingManagement.entity.EmployeeEntity;
import com.training.EmployeeOnboardingManagement.entity.ProjectEntity;
import com.training.EmployeeOnboardingManagement.entity.TaskEntity;
import com.training.EmployeeOnboardingManagement.service.EmployeeService;
import com.training.EmployeeOnboardingManagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employees = employeeService.getAllEmployees();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for (EmployeeEntity employee :
                employees) {
            employeeDTOs.add(EmployeeDTO.EmployeeToEmployeeDTO(employee));
        }
        return employeeDTOs;
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return EmployeeDTO.EmployeeToEmployeeDTO(
                employeeService.createEmployee(
                        EmployeeDTO.EmployeeDTOToEmployee(employeeDTO)
                )
        );
    }

    @GetMapping(path = "{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Integer id) {
        return EmployeeDTO.EmployeeToEmployeeDTO(employeeService.getEmployeeById(id));
    }

    @PutMapping(path = "{id}")
    public EmployeeDTO updateEmployeeById(@PathVariable("id") Integer id, @RequestBody EmployeeDTO employeeDTO) {
        return EmployeeDTO.EmployeeToEmployeeDTO(
                employeeService.updateEmployeeById(id, EmployeeDTO.EmployeeDTOToEmployee(employeeDTO))
        );
    }

    @PatchMapping(path = "{id}")
    public EmployeeDTO updateEmployeeStatusById(@PathVariable("id") Integer id, @RequestBody EmployeeStatusPatchDTO employeeStatusPatchDTO) {
        return EmployeeDTO.EmployeeToEmployeeDTO(
                employeeService.updateEmployeeStatusById(id, employeeStatusPatchDTO.getStatus())
        );
    }
/*
Move to ProjectController
//    here, complete method for getTasksForProject()
    @GetMapping(path = "{id}/project")
    public ProjectAndProjectTasksDTO getEmployeeProject(@PathVariable("id") Integer id) {
        ProjectEntity project = employeeService.getEmployeeProject(id);
        List<TaskEntity> projectTasks = projectService.getTasksForProject(project.getId());

    }

    @PostMapping(path = "{id}/project")
    public void addEmployeeProject(@PathVariable("id") Integer id, @RequestBody ProjectEntity project) {
        employeeService.addEmployeeProject(id, project);
    }

    @PutMapping(path = "{id}/project")
    public void updateEmployeeProject(@PathVariable("id") Integer id, @RequestBody ProjectEntity project) {
        employeeService.updateEmployeeProject(id, project);
    }
*/
/*
Move to OnboardingController
    @GetMapping(path = "{id}/tasks")
    public List<TaskEntity> getEmployeeOnboardingTasks(@PathVariable("id") Integer id) {
        return employeeService.getEmployeeOnboardingTasks(id);
    }

    @PostMapping(path = "{id}/tasks")
    public void addEmployeeOnboardingTask(@PathVariable("id") Integer id, @RequestBody TaskEntity onboardingTask) {
        return employeeService.addEmployeeOnboardingTask(id, onboardingTask);
    }

    @PutMapping(path = "{id}/tasks")
    public void updateEmployeeOnboardingTask(@PathVariable("id") Integer id, @RequestBody TaskEntity onboardingTask) {
        return employeeService.updateEmployeeOnboardingTask(id, onboardingTask);
    }

    @PatchMapping(path = "{id}/tasks/{taskId}")
    public void updateEmployeeOnboardingTaskStatus(@PathVariable("id") Integer id, @PathVariable("taskId") Integer taskId, @RequestParam("status") String status) {
        return employeeService.updateEmployeeOnboardingTaskStatus(id, taskId, status);
    }

    @DeleteMapping(path = "{id}/tasks/{taskId}")
    public void deleteEmployeeOnboardingTask(@PathVariable("id") Integer id, @PathVariable("taskId") Integer taskId) {
        return employeeService.deleteEmployeeOnboardingTask(id, taskId);
    }*/
}
