package com.codna.management.repository;

import com.codna.management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Setting up the repository class
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
