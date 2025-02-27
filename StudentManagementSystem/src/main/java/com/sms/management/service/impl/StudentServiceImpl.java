package com.sms.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sms.management.domain.Student;
import com.sms.management.global.exception.ListEmptyException;
import com.sms.management.global.exception.MissingId;
import com.sms.management.proxy.StudentProxy;
import com.sms.management.repo.MobileNoRepo;
import com.sms.management.repo.StudentRepo;
import com.sms.management.service.StudentServices;
import com.sms.management.util.MapperUtils;

@Service
public class StudentServiceImpl implements StudentServices {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private MapperUtils mapperUtils;

	@Override
	public List<StudentProxy> getAllStudent() {
//		 TODO Auto-generated method stub
		if (!studentRepo.findAll().isEmpty() && !studentRepo.findAll().equals(null)) {
			return mapperUtils.ListofStudentEntitytoStudentProxy(studentRepo.findAll());
		} else {
			throw new ListEmptyException("No data to display this time", 404);
		}

//		List<Student> students = studentRepo.findAll();
//
//		List<StudentProxy> studentProxies = new ArrayList<>();
//
//		for (Student st : students) {
//			st.getStudentBranch().setStudent(null);
//			studentProxies.add(mapperUtils.StudentEntitytoStudentProxy(st));
//		}
//		return studentProxies;
	}

	@Override
	public String saveStudent(StudentProxy studentProxy) {
		// TODO Auto-generated method stub
		Student student = mapperUtils.StudentProxytoStudentEntity(studentProxy);
		student.getMobileNo().stream().forEach(obj -> obj.setStd(student));

		studentRepo.save(student);
		return "Data of student saved successfully.";
	}

	@Override
	public String updateStudent(Long id, StudentProxy studentProxy) {
		// TODO Auto-generated method stub
		if (id != null && studentRepo.findById(id).isPresent()) {
			Student student = mapperUtils.StudentProxytoStudentEntity(studentProxy);
			student.getMobileNo().stream().forEach(obj -> obj.setStd(student));

			studentRepo.save(student);

			return "Data of student updated successfully.";
		} else {
			throw new MissingId("Id is missing in database or Id is invalid", 400);
		}
	}

	@Override
	public String deleteStudent(Long id) {
		// TODO Auto-generated method stub
		if (id != null && studentRepo.findById(id).isPresent()) {
			studentRepo.deleteById(id);
			return "Data of student deleted successfully.";
		} else {
			throw new MissingId("Id is missing in database or Id is invalid", 400);
		}
	}

}
