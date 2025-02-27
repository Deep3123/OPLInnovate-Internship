package com.sms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.management.proxy.StudentProxy;
import com.sms.management.service.StudentServices;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/student")
public class StdController {

	@Autowired
	private StudentServices studentServices;

	@PostMapping("/getAllStudent")
	public List<StudentProxy> getAllStudent() {
		return studentServices.getAllStudent();
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@Valid @RequestBody StudentProxy studentProxy) {
		return studentServices.saveStudent(studentProxy);
	}

	@PostMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable("id") @NotBlank(message = "Id cannot be null or empty.") String id,
			@Valid @RequestBody StudentProxy studentProxy) {
		return studentServices.updateStudent(Long.parseLong(id), studentProxy);
	}

	@PostMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") @NotBlank(message = "Id cannot be null or empty.") String id) {
		return studentServices.deleteStudent(Long.parseLong(id));
	}
}
