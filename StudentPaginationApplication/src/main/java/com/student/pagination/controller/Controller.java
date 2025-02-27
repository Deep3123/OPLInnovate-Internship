package com.student.pagination.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.student.pagination.domain.StudentEntity;
import com.student.pagination.proxy.HelperProxy;
import com.student.pagination.proxy.StudentProxy;
import com.student.pagination.services.Services;

@RestController
public class Controller {
	@Autowired
	private Services services;

	@GetMapping("/save-student")
	public String saveStudent(StudentProxy studentProxy) {
		return services.saveStudent(studentProxy);
	}

	@GetMapping("/save-student-record/{student_size}")
	public String saveStudentRecord(@PathVariable("student_size") Long student_size) {
		return services.saveStudentRecord(student_size);
	}

	@GetMapping("/retrieve-all-student-records")
	public List<StudentProxy> retrieveAllStudentRecords() {
		return services.retrieveAllStudentRecords();
	}

	@GetMapping("/get-all-sorted-student/{attrname}")
	public List<StudentProxy> getAllSortedStudent(@PathVariable("attrname") String attrname) {
		// TODO Auto-generated method stub
		return services.getAllSortedStudent(attrname);
	}

	@GetMapping("/get-student-page-wise/{pagenumber}/{pagesize}")
	public Page<StudentEntity> getStudentPageWise(@PathVariable("pagenumber") Integer pagenumber,
			@PathVariable("pagesize") Integer pagesize) {
		// TODO Auto-generated method stub
		return services.getStudentPageWise(pagenumber, pagesize);
	}

	@GetMapping("/get-student-page-wise/{pagenumber}/{pagesize}/{attrname}")
	public Page<StudentEntity> getSortedStudentPageWise(@PathVariable("pagenumber") Integer pagenumber,
			@PathVariable("pagesize") Integer pagesize, @PathVariable("attrname") String attrname) {
		// TODO Auto-generated method stub
		return services.getSortedStudentPageWise(pagenumber, pagesize, attrname);
	}

	@GetMapping("/test-jpa-methods/{fname}/{lname}")
	public List<StudentProxy> testJpaMethods(@PathVariable("fname") String fname, @PathVariable("lname") String lname) {
		// TODO Auto-generated method stub
		return services.testJpaMethods(fname, lname);
	}

	@GetMapping("/test-jpa-methods-with-one-para/{name}")
	public List<StudentProxy> testJpaMethods(@PathVariable("name") String name) {
		// TODO Auto-generated method stub
		return services.testJpaMethodsWithOneParameter(name);
	}

	@GetMapping("/find-by-range/{start}/{end}")
	public List<StudentProxy> findByRange(@PathVariable("start") Long start, @PathVariable("end") Long end) {
		return services.findByRange(start, end);
	}

	@GetMapping("/test-jpa-methods-for-first-name/{name}")
	public List<StudentProxy> findByFirstNameOrderByFirstNameAsc(@PathVariable("name") String name) {
		// TODO Auto-generated method stub
		return services.findByFirstNameOrderByFirstNameAsc(name);
	}

	@GetMapping("/delete-by-first-name/{firstname}")
	public String deleteByFirstName(@PathVariable("firstname") String firstname) {
		// TODO Auto-generated method stub
		return services.deleteByFirstName(firstname);
	}

	@GetMapping("/get-student-by-first-name-and-last-name/{firstname}/{lastname}")
	public List<StudentProxy> getStudentByFirstNameAndLastName(@PathVariable("firstname") String firstname,
			@PathVariable("lastname") String lastname) {
		// TODO Auto-generated method stub
		return services.getStudentByFirstNameAndLastName(firstname, lastname);
	}

	@GetMapping("/delete-student-data/{firstname}/{lastname}")
	public String deleteStudentData(@PathVariable("firstname") String firstname,
			@PathVariable("lastname") String lastname) {
		// TODO Auto-generated method stub
		return services.deleteStudentData(firstname, lastname);
	}

	@GetMapping("/update-student-data/{id}/{firstname}/{lastname}")
	public String updateStudentData(@PathVariable("id") Long id, @PathVariable("firstname") String firstname,
			@PathVariable("lastname") String lastname) {
		// TODO Auto-generated method stub
		return services.updateStudentData(id, firstname, lastname);
	}

	@GetMapping("/insert-student-data/{firstname}/{lastname}/{email}")
	public String insertStudentData(@PathVariable("firstname") String firstname,
			@PathVariable("lastname") String lastname, @PathVariable("email") String email) {
		// TODO Auto-generated method stub
		return services.insertStudentData(firstname, lastname, email);
	}

	@GetMapping("/select-student-data/{email}")
	public StudentProxy selectStudentData(@PathVariable("email") String email) {
		// TODO Auto-generated method stub
		return services.selectStudentData(email);
	}

	@GetMapping("/get-student-by-pincode")
	public List<HelperProxy> getStudentByPincode() {
		// TODO Auto-generated method stub
		return services.getStudentByPincode();
	}

	@GetMapping("/get-student-by-pincode-using-native")
	public List<Object[]> getStudentByPincodeUsingNative() {
		// TODO Auto-generated method stub
		return services.getStudentByPincodeUsingNative();
	}

	@GetMapping("/delete-student-data-using-native/{firstname}/{lastname}")
	public String deleteStudentDataUsingNative(@PathVariable("firstname") String firstname,
			@PathVariable("lastname") String lastname) {
		// TODO Auto-generated method stub
		return services.deleteStudentDataUsingNative(firstname, lastname);
	}
}
