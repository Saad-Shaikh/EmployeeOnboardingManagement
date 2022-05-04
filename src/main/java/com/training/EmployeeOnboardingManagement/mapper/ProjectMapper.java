package com.training.EmployeeOnboardingManagement.mapper;

import com.training.EmployeeOnboardingManagement.dto.ProjectAndProjectTasksDTO;
import com.training.EmployeeOnboardingManagement.dto.ProjectCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.ProjectUpdateDTO;
import com.training.EmployeeOnboardingManagement.entity.ProjectEntity;
import com.training.EmployeeOnboardingManagement.entity.ProjectHasProjectTaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProjectHasProjectTaskMapper.class)
public interface ProjectMapper {
    @Mapping(target = "id", ignore = true)
    ProjectEntity mapCreateDTOToEntity(ProjectCreateDTO projectCreateDTO);

    void mapUpdateDTOToEntity(ProjectUpdateDTO projectUpdateDTO, @MappingTarget ProjectEntity project);

    @Mapping(target = "projectTasks", source = "projectHasProjectTaskList")
    ProjectAndProjectTasksDTO mapEntityToProjectAndProjectTasksDTO(ProjectEntity project, List<ProjectHasProjectTaskEntity> projectHasProjectTaskList);
}
