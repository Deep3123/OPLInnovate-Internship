package com.ems.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ems.security.proxy.EmployeeProxy;
import com.ems.security.proxy.LoginRequest;
import com.ems.security.services.EmployeeServices;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeServices emp;

	@GetMapping("/get-all-employee-Details")
	public ResponseEntity<?> getAllEmployeeDetails() {
		return new ResponseEntity<>(emp.getAllEmployeeDetails(), HttpStatus.OK);
	}

	@GetMapping("/get-employee-details-by-id/{id}")
	public ResponseEntity<?> getEmployeeDetailsById(@PathVariable Long id) {
		return new ResponseEntity<>(emp.getEmployeeDetailsById(id), HttpStatus.OK);
	}

	@PostMapping("/save-employee")
	public ResponseEntity<?> saveAdminDetails(@RequestBody EmployeeProxy employeeProxy) {
		return new ResponseEntity<>(emp.saveEmployeeDetails(employeeProxy), HttpStatus.CREATED);
	}

	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest req) {
		return new ResponseEntity<>(emp.login(req), HttpStatus.ACCEPTED);
	}
}
