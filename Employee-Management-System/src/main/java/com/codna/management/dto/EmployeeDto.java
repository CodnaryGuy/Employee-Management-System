package com.codna.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created DTO class to get as Response
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
