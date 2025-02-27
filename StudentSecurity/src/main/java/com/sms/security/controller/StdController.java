package com.sms.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sms.security.proxy.StudentProxy;
import com.sms.security.proxy.UserProxy;
import com.sms.security.services.UserServices;
import com.sms.security.services.impl.UserRepoService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StdController {
	private static List<StudentProxy> list = new ArrayList<>();

	@Autowired
	private UserServices userRepoService;

	static {
		list.add(new StudentProxy(1L, "Alice", "alice123@gmail.com", "Computer Science", "7852639789"));
		list.add(new StudentProxy(2L, "Bob", "bob3421@gmail.com", "Electrical Engineering", "8596474585"));
		list.add(new StudentProxy(3L, "Charlie", "charlie8718@gmail.com", "Mechanical Engineering", "8956237410"));
		list.add(new StudentProxy(4L, "Diana", "dia2763@gmail.com", "Civil Engineering", "8596412370"));
		list.add(new StudentProxy(5L, "Eve", "eve789@gmail.com", "Biotechnology", "7418529630"));
	}

	@GetMapping("/")
	public String welcomeStudent() {
		return "Welcome to our website!!!";
	}

	@GetMapping("/get-all-student-data")
	public List<StudentProxy> getAllStudentData() {
		return list;
	}

	@PostMapping("/save-student-data")
	public List<StudentProxy> saveStudentData(@RequestBody StudentProxy studentProxy) {
		list.add(studentProxy);
		return list;
	}

	@GetMapping("/get-session-id")
	public String getSessionId(HttpServletRequest req) {
		return req.getSession().getId();
	}

	@GetMapping("/get-csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest req) {
		return (CsrfToken) req.getAttribute("_csrf");
	}

	@GetMapping("/loginform")
	public String login() {
		return "Welcome to login page!!";
	}

	@GetMapping("/registrationform")
	public String registrationform() {
		return "Welcome to registrationform page!!";
	}
	
	@PostMapping("/save-user-details")
	public String saveUserDetails(@RequestBody UserProxy user) {
		return userRepoService.saveUserDetails(user);
	}

	@GetMapping("/get-all-user-details")
	public List<UserProxy> getAllUserDetails() {
		return userRepoService.getAllUserDetails();
	}
}
