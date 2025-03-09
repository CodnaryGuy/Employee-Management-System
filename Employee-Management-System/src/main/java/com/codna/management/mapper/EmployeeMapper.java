package com.codna.management.mapper;

import com.codna.management.dto.EmployeeDto;
import com.codna.management.entity.Employee;

/**
 * created mapper calss to
 * map employee entity to employeeDto
 * and employeeDto to employee entity
 */
public class EmployeeMapper {

    /**
     * converting employee entity to employeeDto
     *
     * @param employee
     * @return the employee Dto
     */
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    /**
     * converting employeeDto to employee entity
     *
     * @param employeeDto
     * @return
     */
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
