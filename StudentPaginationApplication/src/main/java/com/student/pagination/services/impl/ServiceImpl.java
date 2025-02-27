package com.student.pagination.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.student.pagination.domain.StudentEntity;
import com.student.pagination.proxy.HelperProxy;
import com.student.pagination.proxy.StudentProxy;
import com.student.pagination.repo.Repo;
import com.student.pagination.services.Services;
import com.student.pagination.util.Utility;

//import jakarta.transaction.Transactional;

@Service
public class ServiceImpl implements Services {

	@Autowired
	private Repo repo;

	@Autowired
	private Utility utility;

	@Override
	public String saveStudent(StudentProxy studentProxy) {
		// TODO Auto-generated method stub
		repo.save(utility.StudentProxytoStudentEntity(studentProxy));
		return "Student record added successfully.";
	}

	@Override
	public String saveStudentRecord(Long studentRecordSize) {
		// TODO Auto-generated method stub
		for (int i = 0; i < studentRecordSize; i++)
			generateStudentData();

		return studentRecordSize + " student record added successfully.";
	}

	@Override
	public List<StudentProxy> retrieveAllStudentRecords() {
		// TODO Auto-generated method stub
		return utility.ListofStudentEntitytoStudentProxy(repo.findAll());
	}

	private void generateStudentData() {
		Faker faker = new Faker();
		StudentProxy studentProxy = new StudentProxy();

		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();

		studentProxy.setFirstName(firstname);
		studentProxy.setLastName(lastname);
		studentProxy.setMobileNo(faker.phoneNumber().phoneNumber());
		studentProxy.setAddress(faker.address().fullAddress());
		studentProxy.setEmailId(firstname + "." + lastname + "@gmail.com");
		studentProxy.setPinCode(faker.address().zipCode());

		repo.save(utility.StudentProxytoStudentEntity(studentProxy));
	}

	@Override
	public List<StudentProxy> getAllSortedStudent(String attrname) {
		// TODO Auto-generated method stub
		return utility.ListofStudentEntitytoStudentProxy(repo.findAll(Sort.by(Sort.Direction.DESC, attrname)));
	}

	@Override
	public Page<StudentEntity> getStudentPageWise(Integer pagenumber, Integer pagesize) {
		// TODO Auto-generated method stub
		return repo.findAll(PageRequest.of(pagenumber, pagesize));
	}

	@Override
	public Page<StudentEntity> getSortedStudentPageWise(Integer pagenumber, Integer pagesize, String attrname) {
		// TODO Auto-generated method stub
		return repo.findAll(PageRequest.of(pagenumber, pagesize, Sort.by(Sort.Direction.ASC, attrname)));
	}

	@Override
	public List<StudentProxy> testJpaMethods(String fname, String lname) {
		// TODO Auto-generated method stub
		return utility.ListofStudentEntitytoStudentProxy(repo.findByFirstNameOrLastName(fname, lname));
	}

	@Override
	public List<StudentProxy> testJpaMethodsWithOneParameter(String name) {
		// TODO Auto-generated method stub
		return utility.ListofStudentEntitytoStudentProxy(repo.findByFirstNameLike("__" + name + "__"));
	}

	@Override
	public List<StudentProxy> findByRange(Long start, Long end) {
//		List<StudentProxy> studentProxies = new ArrayList<>();
//
//		for (Long i = start; i <= end; i++) {
//			studentProxies.add(utility.StudentEntitytoStudentProxy(repo.findById(i).get()));
//		}
//
//		return studentProxies;

		return utility.ListofStudentEntitytoStudentProxy(repo.findByIdBetween(start, end));
	}

	@Override
	public List<StudentProxy> findByFirstNameOrderByFirstNameAsc(String firstname) {
		// TODO Auto-generated method stub
		return utility.ListofStudentEntitytoStudentProxy(repo.findByFirstNameOrderByLastNameDesc(firstname));
	}

	@Override
//	@Transactional
	public String deleteByFirstName(String firstname) {
		// TODO Auto-generated method stub
		repo.deleteByFirstName(firstname);
		return "Student data deleted with the specified first name: " + firstname;
	}

	@Override
	public List<StudentProxy> getStudentByFirstNameAndLastName(String firstname, String lastname) {
		// TODO Auto-generated method stub
		return utility.ListofStudentEntitytoStudentProxy(repo.findByFirstNameAndLastName(firstname, lastname));
	}

	@Override
	public String deleteStudentData(String firstname, String lastname) {
		// TODO Auto-generated method stub
		try {
			repo.deleteStudentData(firstname, lastname);
			return "Student data deleted successfully.";
		}

		catch (Exception e) {
			return "Maybe you missed @Transanctional annotation.";
		}
	}

	@Override
	public String updateStudentData(Long id, String firstname, String lastname) {
		// TODO Auto-generated method stub
		repo.updateStudentData(id, firstname, lastname);
		return "Student data updated successfully.";
	}

	@Override
	public String insertStudentData(String firstname, String lastname, String emailid) {
		// TODO Auto-generated method stub
		repo.insertStudentData(firstname, lastname, emailid);
		return "Student data inserted into database successfully.";
	}

	@Override
	public StudentProxy selectStudentData(String emailid) {
		// TODO Auto-generated method stub
		StudentEntity studentEntity = repo.selectStudentData(emailid);

		return new StudentProxy(studentEntity.getFirstName(), studentEntity.getLastName());
	}

	@Override
	public List<HelperProxy> getStudentByPincode() {
		// TODO Auto-generated method stub
		return utility.ListofHelperEntitytoHelperProxy(repo.getStudentByPincode());
	}

	@Override
	public List<Object[]> getStudentByPincodeUsingNative() {
		// TODO Auto-generated method stub
		return repo.getStudentByPincodeUsingNative();
	}

	@Override
	public String deleteStudentDataUsingNative(String firstname, String lastname) {
		// TODO Auto-generated method stub
		try {
			repo.deleteStudentDataUsingNative(firstname, lastname);
			return "Student data deleted successfully.";
		}

		catch (Exception e) {
			return "Maybe you missed @Transanctional annotation.";
		}
	}
}