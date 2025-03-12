package com.ems.security.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ems.security.domain.Employee;
import com.ems.security.proxy.EmployeeImageProxy;
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
	public ResponseEntity<?> saveEmployeeDetails(@RequestBody EmployeeProxy employeeProxy) {
		return new ResponseEntity<>(emp.saveEmployeeDetails(employeeProxy), HttpStatus.CREATED);
	}

	@PostMapping("/save-employee-with-image")
	public ResponseEntity<?> saveEmployeeDetailsWithProfileImage(@RequestPart("emp") EmployeeProxy employeeProxy,
			@RequestPart("image") MultipartFile file) throws IOException {
		if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")) {
			return new ResponseEntity<>(emp.saveEmployeeDetailsWithImage(employeeProxy, file), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Please upload valid image. Valid Image formats are JPEG/JPG/PNG.",
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest req) {
		return new ResponseEntity<>(emp.login(req), HttpStatus.ACCEPTED);
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<?> viewMultiMediaData(@PathVariable("id") String id) {
		EmployeeImageProxy employee = emp.viewMultiMediaData(id);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(employee.getContentType()))
				.body(employee.getFileData());
	}

	@GetMapping("/get-employee-details-page-wise/{pagenumber}/{pagesize}")
	public Page<EmployeeProxy> getEmployeeDetailsPageWise(@PathVariable("pagenumber") Integer pagenumber,
			@PathVariable("pagesize") Integer pagesize) {
		// TODO Auto-generated method stub
		return emp.getEmployeeDetailsPageWise(pagenumber, pagesize);
	}

	@GetMapping("/get-sorted-employee-details-page-wise/{pagenumber}/{pagesize}/{attrname}")
	public Page<EmployeeProxy> getSortedEmployeeDetailsPageWise(@PathVariable("pagenumber") Integer pagenumber,
			@PathVariable("pagesize") Integer pagesize, @PathVariable("attrname") String attrname) {
		// TODO Auto-generated method stub
		return emp.getSortedEmployeeDetailsPageWise(pagenumber, pagesize, attrname);
	}
}
