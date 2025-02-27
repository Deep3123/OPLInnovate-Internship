package com.student.pagination.services;

import java.security.PublicKey;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.student.pagination.domain.StudentEntity;
import com.student.pagination.proxy.HelperProxy;
import com.student.pagination.proxy.StudentProxy;

public interface Services {
	public String saveStudent(StudentProxy studentProxy);

	public String saveStudentRecord(Long id);

	public List<StudentProxy> retrieveAllStudentRecords();

	public List<StudentProxy> getAllSortedStudent(String attrname);

	public Page<StudentEntity> getStudentPageWise(Integer pagenumber, Integer pagesize);

	public Page<StudentEntity> getSortedStudentPageWise(Integer pagenumber, Integer pagesize, String attrname);

	public List<StudentProxy> testJpaMethods(String fname, String lname);

	public List<StudentProxy> testJpaMethodsWithOneParameter(String name);

	public List<StudentProxy> findByRange(Long start, Long end);

	public List<StudentProxy> findByFirstNameOrderByFirstNameAsc(String firstname);

	public String deleteByFirstName(String firstname);

	public List<StudentProxy> getStudentByFirstNameAndLastName(String firstname, String lastname);

	public String deleteStudentData(String firstname, String lastname);

	public String updateStudentData(Long id, String firstname, String lastname);

	public String insertStudentData(String firstname, String lastname, String emailid);

	public StudentProxy selectStudentData(String emailid);

	public List<Object[]> getStudentByPincodeUsingNative();

	public List<HelperProxy> getStudentByPincode();
	
	public String deleteStudentDataUsingNative(String firstname, String lastname);

}
