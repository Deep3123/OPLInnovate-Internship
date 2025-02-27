package com.sms.management.service;

import java.util.List;
import com.sms.management.proxy.StudentProxy;

public interface StudentServices {
	public List<StudentProxy> getAllStudent();

	public String saveStudent(StudentProxy studentProxy);

	public String updateStudent(Long id, StudentProxy studentProxy);

	public String deleteStudent(Long id);
}
