package com.training.EmployeeOnboardingManagement.mapper;

import com.training.EmployeeOnboardingManagement.dto.ProjectTaskDetailDTO;
import com.training.EmployeeOnboardingManagement.dto.ProjectTaskUpdateDTO;
import com.training.EmployeeOnboardingManagement.entity.ProjectHasProjectTaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = TaskMapper.class)
public interface ProjectHasProjectTaskMapper {
    List<ProjectTaskDetailDTO> mapEntityListToDetailDTOList(List<ProjectHasProjectTaskEntity> projectHasProjectTask);
    void mapUpdateDTOToEntity(ProjectTaskUpdateDTO projectTaskUpdateDTO, @MappingTarget ProjectHasProjectTaskEntity projectHasProjectTask);
}
