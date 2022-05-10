package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dao.EmployeeRepository;
import com.training.EmployeeOnboardingManagement.dataproviders.EmployeeTestDataProvider;
import com.training.EmployeeOnboardingManagement.dto.*;
import com.training.EmployeeOnboardingManagement.entity.EmployeeEntity;
import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import com.training.EmployeeOnboardingManagement.mapper.EmployeeMapper;
import com.training.EmployeeOnboardingManagement.service.impl.EmployeeServiceImpl;
import com.training.EmployeeOnboardingManagement.validator.EmployeeValidator;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @Mock
    private EmployeeValidator employeeValidator;

    @Mock
    private EmployeeMentorsService employeeMentorsService;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeClass
    public void setup() {
        employeeService = new EmployeeServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void EST_01_getAllEmployees_success() {
        List<EmployeeEntity> employeeEntityList = Arrays.asList(new EmployeeEntity());
        when(employeeRepository.findAll()).thenReturn(employeeEntityList);
        employeeService.getAllEmployees();
        verify(employeeRepository, times(1)).findAll();
    }

    @Test(dataProviderClass = EmployeeTestDataProvider.class, dataProvider = "getEmployeeCreateDTO")
    public void EST_02_createEmployee_success(EmployeeCreateDTO employeeCreateDTO) {
        when(employeeMapper.mapCreateDTOToEntity(employeeCreateDTO)).thenReturn(new EmployeeEntity());
        employeeService.createEmployee(employeeCreateDTO);
        verify(employeeValidator, times(1)).validate(employeeCreateDTO);
        verify(employeeRepository, times(1)).save(new EmployeeEntity());
    }

    @Test
    public void EST_03_getEmployeeById_success() {
        EmployeeDetailDTO detailDTO = new EmployeeDetailDTO();
        detailDTO.setMentors(new HashSet<>());

        when(employeeRepository.findById(1)).thenReturn(Optional.of(new EmployeeEntity()));
        when(employeeMapper.mapEntityToDetailDTO(any())).thenReturn(detailDTO);
        assertEquals(employeeService.getEmployeeById(1), detailDTO);
    }

    @Test(dataProviderClass = EmployeeTestDataProvider.class, dataProvider = "getEmployeeUpdateDTO")
    public void EST_04_updateEmployeeById_success(EmployeeUpdateDTO employeeUpdateDTO) {
        when(employeeRepository.findById(1)).thenReturn(Optional.of(new EmployeeEntity()));
        employeeService.updateEmployeeById(1, employeeUpdateDTO);
        verify(employeeValidator, times(1)).validate(employeeUpdateDTO);
        verify(employeeMapper, times(1)).mapUpdateDTOToEntity(employeeUpdateDTO, new EmployeeEntity());
    }

    @Test(dataProviderClass = EmployeeTestDataProvider.class, dataProvider = "getEmployeeStatusPatchDTO")
    public void EST_05_updateEmployeeStatusById_success(EmployeeStatusPatchDTO employeeStatusPatchDTO) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setStatus(EmployeeStatus.ON_PROBATION);
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
        employeeService.updateEmployeeStatusById(1, employeeStatusPatchDTO);
        verify(employeeMapper, times(1)).mapStatusPatchDTOToEntity(employeeStatusPatchDTO, employee);
    }
}
