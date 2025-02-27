package com.ems.security.services;

import java.util.List;
import com.ems.security.proxy.EmployeeProxy;
import com.ems.security.proxy.LoginRequest;
import com.ems.security.proxy.LoginResponse;

public interface EmployeeServices {
	public List<EmployeeProxy> getAllEmployeeDetails();

	public EmployeeProxy getEmployeeDetailsById(Long id);

	public String saveEmployeeDetails(EmployeeProxy employeeProxy);

	public LoginResponse login(LoginRequest req);
}
