package com.codna.management.service.impl;

import com.codna.management.dto.EmployeeDto;
import com.codna.management.entity.Employee;
import com.codna.management.exception.ResourceNotFoundException;
import com.codna.management.mapper.EmployeeMapper;
import com.codna.management.repository.EmployeeRepository;
import com.codna.management.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for business logic
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Method to save or add the employees
     * @param employeeDto
     * @return
     */
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    /**
     * Method to get employee by ID
     * @param employeeId
     * @return
     */
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with the given id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    /**
     * Method to get all employees
     * @return
     */
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    /**
     * Method to update the employee data using employee Id
     * @param employeeId
     * @param updateEmployee
     * @return
     */
    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    /**
     * Method to delete the employees by ID
     * @param employeeId
     */
    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
