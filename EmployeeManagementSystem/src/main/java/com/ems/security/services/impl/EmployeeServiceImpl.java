package com.ems.security.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ems.security.domain.Employee;
import com.ems.security.proxy.EmployeeProxy;
import com.ems.security.proxy.LoginRequest;
import com.ems.security.proxy.LoginResponse;
import com.ems.security.repo.EmployeeRepo;
import com.ems.security.services.EmployeeServices;
import com.ems.security.util.JwtService;
import com.ems.security.util.MapperUtil;

@Service
public class EmployeeServiceImpl implements EmployeeServices {
	@Autowired
	private EmployeeRepo emp;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private JwtService jwtService;

	@Override
	public List<EmployeeProxy> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		return MapperUtil.convertListofValue(emp.findAll(), EmployeeProxy.class);
	}

	@Override
	public EmployeeProxy getEmployeeDetailsById(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = emp.findById(id);

		if (employee.isPresent())
			return MapperUtil.convertValue(employee.get(), EmployeeProxy.class);

		throw new UsernameNotFoundException("User not valid.");
	}

	@Override
	public String saveEmployeeDetails(EmployeeProxy employeeProxy) {
		// TODO Auto-generated method stub
		employeeProxy.setPassword(passwordEncoder.encode(employeeProxy.getPassword()));
		emp.save(MapperUtil.convertValue(employeeProxy, Employee.class));
		return "Employee data saved successfully.";
	}

	@Override
	public LoginResponse login(LoginRequest req) {
		// TODO Auto-generated method stub
//		Optional<Employee> employee = emp.findByUsername(req.getUsername());

		System.err.println("Token");
		
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(req.getUsername(),
				req.getPassword());

		Authentication authenticate = manager.authenticate(auth);

		if (authenticate.isAuthenticated())
			return new LoginResponse(req.getUsername(), jwtService.generateToken(req.getUsername()));

//		if (employee.isPresent())

		throw new UsernameNotFoundException("User not valid.");
	}

}
