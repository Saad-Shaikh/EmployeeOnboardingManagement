package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dao.EmployeeRepository;
import com.training.EmployeeOnboardingManagement.dataproviders.EmployeeTestDataProvider;
import com.training.EmployeeOnboardingManagement.dto.EmployeeCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.EmployeeDetailDTO;
import com.training.EmployeeOnboardingManagement.dto.EmployeeStatusPatchDTO;
import com.training.EmployeeOnboardingManagement.dto.EmployeeUpdateDTO;
import com.training.EmployeeOnboardingManagement.entity.EmployeeEntity;
import com.training.EmployeeOnboardingManagement.mapper.EmployeeMapper;
import com.training.EmployeeOnboardingManagement.service.impl.EmployeeServiceImpl;
import com.training.EmployeeOnboardingManagement.validator.ConstraintValidator;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private ConstraintValidator constraintValidator;

    @Mock
    private EmployeeMapper employeeMapper;

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
        verify(constraintValidator, times(1)).validateConstraints(employeeCreateDTO);
        verify(employeeRepository, times(1)).save(new EmployeeEntity());
    }

    @Test
    public void EST_03_getEmployeeById_success() {
        when(employeeRepository.findById(1)).thenReturn(Optional.of(new EmployeeEntity()));
        when(employeeMapper.mapEntityToDetailDTO(any())).thenReturn(new EmployeeDetailDTO());
        assertEquals(employeeService.getEmployeeById(1), new EmployeeDetailDTO());
    }

    @Test(dataProviderClass = EmployeeTestDataProvider.class, dataProvider = "getEmployeeUpdateDTO")
    public void EST_04_updateEmployeeById_success(EmployeeUpdateDTO employeeUpdateDTO) {
        when(employeeRepository.findById(1)).thenReturn(Optional.of(new EmployeeEntity()));
        employeeService.updateEmployeeById(1, employeeUpdateDTO);
        verify(constraintValidator, times(1)).validateConstraints(employeeUpdateDTO);
        verify(employeeMapper, times(1)).mapUpdateDTOToEntity(employeeUpdateDTO, new EmployeeEntity());
    }

    @Test(dataProviderClass = EmployeeTestDataProvider.class, dataProvider = "getEmployeeStatusPatchDTO")
    public void EST_05_updateEmployeeStatusById_success(EmployeeStatusPatchDTO employeeStatusPatchDTO) {
        when(employeeRepository.findById(1)).thenReturn(Optional.of(new EmployeeEntity()));
        employeeService.updateEmployeeStatusById(1, employeeStatusPatchDTO);
        verify(constraintValidator, times(1)).validateConstraints(employeeStatusPatchDTO);
        verify(employeeMapper, times(1)).mapStatusPatchDTOToEntity(employeeStatusPatchDTO, new EmployeeEntity());
    }
}
