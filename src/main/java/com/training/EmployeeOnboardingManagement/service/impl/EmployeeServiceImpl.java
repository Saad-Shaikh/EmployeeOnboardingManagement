package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dao.EmployeeRepository;
import com.training.EmployeeOnboardingManagement.entity.*;
import com.training.EmployeeOnboardingManagement.exception.ErrorMessage;
import com.training.EmployeeOnboardingManagement.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity createEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeEntity getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundException(new ErrorMessage("Employee with id " + id + " does not exist!"))
        );
    }

    @Override
    public EmployeeEntity updateEmployeeById(Integer id, EmployeeEntity newEmployee) {
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Employee with id " + id + " does not exist!")
        );

        employee.setName(newEmployee.getName());
        employee.setDob(newEmployee.getDob());
        employee.setAddress(newEmployee.getAddress());
        employee.setPhone(newEmployee.getPhone());
        employee.setDesignation(newEmployee.getDesignation());
        employee.setOnboardingStartDate(newEmployee.getOnboardingStartDate());
        employee.setOnboardingEndDate(newEmployee.getOnboardingEndDate());
        return employee;
    }

    @Override
    public EmployeeEntity updateEmployeeStatusById(Integer id, String status) {
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Employee with id " + id + " does not exist!")
        );

        /*if (!employee.getStatus().equals(status)) {
            employee.setStatus(status);
        }*/
        return employee;
    }
/*
Move to ProjectService
    @Override
    public ProjectEntity getEmployeeProject(Integer id) {
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Employee with id " + id + " does not exist!")
        );
        return employee.getProject();
    }

//    add project and assign all project tasks to project
    @Override
    @Transactional
    public ProjectEntity addEmployeeProject(Integer id, ProjectEntity project) {
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Employee with id " + id + " does not exist!")
        );

        ProjectEntity savedProject = projectService.addProject(project);
        List<TaskEntity> projectTasks = projectTaskService.getProjectTasks();
        projectHasProjectTaskService.addAllTasksToProject(savedProject, projectTasks);

        employee.setProject(savedProject);
        return employee.getProject();
    }

    @Override
    public ProjectEntity updateEmployeeProject(Integer id, ProjectEntity newProject) {
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Employee with id " + id + " does not exist!")
        );

        ProjectEntity project = employee.getProject();
        if (project == null) {
            throw new IllegalStateException("Employee with id " + id + " does not have a project!");
        }

        project.setName(newProject.getName());
        project.setDescription(newProject.getDescription());
        project.setRepoUrl(newProject.getRepoUrl());
    }
*/
/*
Move to OnboardingService
    @Override
    public List<TaskEntity> getEmployeeOnboardingTasks(Integer id) {
        return null;
    }

    @Override
    public TaskEntity addEmployeeOnboardingTask(Integer id, TaskEntity onboardingTask) {
        return null;
    }

    @Override
    public TaskEntity updateEmployeeOnboardingTask(Integer id, TaskEntity onboardingTask) {
        return null;
    }

    @Override
    public String updateEmployeeOnboardingTaskStatus(Integer id, Integer taskId, String status) {
        return null;
    }

    @Override
    public void deleteEmployeeOnboardingTask(Integer id, Integer taskId) {
        return null;
    }*/
}
