package com.ems.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ems.security.domain.Employee;
import com.ems.security.repo.EmployeeRepo;

@Service
public class EmployeeDetailsService implements UserDetailsService {
	@Autowired
	private EmployeeRepo emp;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> employee = emp.findByUsername(username);

		if (employee.isEmpty())
			throw new UsernameNotFoundException("User not found with this username");

		return new EmployeeDetails(employee.get());
	}

}
