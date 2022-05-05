package com.training.EmployeeOnboardingManagement.mapper;

import com.training.EmployeeOnboardingManagement.dto.TeamCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.TeamNameDTO;
import com.training.EmployeeOnboardingManagement.dto.TeamUpdateDTO;
import com.training.EmployeeOnboardingManagement.entity.TeamEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamNameDTO mapEntityToNameDTO(TeamEntity team);

    TeamEntity mapCreateDTOToEntity(TeamCreateDTO teamCreateDTO);

    @Mapping(target = "id", ignore = true)
    void mapUpdateDTOToEntity(TeamUpdateDTO teamUpdateDTO, @MappingTarget TeamEntity team);

    List<TeamNameDTO> mapEntityListToNameDTOList(List<TeamEntity> teamEntityList);
}
