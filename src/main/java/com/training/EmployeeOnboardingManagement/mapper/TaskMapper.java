package com.training.EmployeeOnboardingManagement.mapper;

import com.training.EmployeeOnboardingManagement.dto.TaskCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.TaskDetailDTO;
import com.training.EmployeeOnboardingManagement.dto.TaskUpdateDTO;
import com.training.EmployeeOnboardingManagement.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDetailDTO mapEntityToDetailDTO(TaskEntity task);
    List<TaskDetailDTO> mapEntityListToDetailDTOList(List<TaskEntity> taskList);
    List<TaskEntity> mapDetailDTOListToEntityList(List<TaskDetailDTO> taskDetailDTOList);
    TaskEntity mapCreateDTOToEntity(TaskCreateDTO taskCreateDTO);
    TaskEntity mapUpdateDTOToEntity(TaskUpdateDTO taskUpdateDTO, @MappingTarget TaskEntity task);
}
