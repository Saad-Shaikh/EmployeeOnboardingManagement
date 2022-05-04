package com.training.EmployeeOnboardingManagement.controller;

import com.training.EmployeeOnboardingManagement.dto.TaskCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.TaskDetailDTO;
import com.training.EmployeeOnboardingManagement.dto.TaskUpdateDTO;
import com.training.EmployeeOnboardingManagement.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping()
    public List<TaskDetailDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public TaskDetailDTO createTask(@RequestBody @Valid TaskCreateDTO taskCreateDTO) {
        return taskService.createTask(taskCreateDTO);
    }

    @PutMapping(path = "{id}")
    public TaskDetailDTO updateTask(@PathVariable("id") Integer id, @RequestBody @Valid TaskUpdateDTO taskUpdateDTO) {
        return taskService.updateTask(id, taskUpdateDTO);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTask(@PathVariable("id") Integer id) {
        taskService.deleteTask(id);
    }
}
