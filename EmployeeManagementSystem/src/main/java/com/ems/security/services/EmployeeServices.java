package com.ems.security.services;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.ems.security.domain.Employee;
import com.ems.security.proxy.EmployeeImageProxy;
import com.ems.security.proxy.EmployeeProxy;
import com.ems.security.proxy.LoginRequest;
import com.ems.security.proxy.LoginResponse;

public interface EmployeeServices {
	public List<EmployeeProxy> getAllEmployeeDetails();

	public EmployeeProxy getEmployeeDetailsById(Long id);

	public String saveEmployeeDetails(EmployeeProxy employeeProxy);

	public String saveEmployeeDetailsWithImage(EmployeeProxy employeeProxy, MultipartFile file) throws IOException;

	public LoginResponse login(LoginRequest req);

	public EmployeeImageProxy viewMultiMediaData(String id);

	public Page<EmployeeProxy> getEmployeeDetailsPageWise(Integer pagenumber, Integer pagesize);

	public Page<EmployeeProxy> getSortedEmployeeDetailsPageWise(Integer pagenumber, Integer pagesize, String attrname);
}
