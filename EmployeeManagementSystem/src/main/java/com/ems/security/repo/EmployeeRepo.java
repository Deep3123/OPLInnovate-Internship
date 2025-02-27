package com.ems.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.security.domain.Employee;
import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	Optional<Employee> findByUsername(String username);
}
