package com.ems.filehandling.service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.ems.filehandling.domain.EmployeeEntity;
import com.ems.filehandling.proxy.EmployeeProfileImageProxy;
import com.ems.filehandling.proxy.EmployeeProxy;

public interface EmployeeServices {
	public String uploadMultiMediaData(MultipartFile multipartFile);

	public EmployeeProfileImageProxy downloadMultiMediaData(String fileId);

	public String uploadMultiMediaDataAtDynamicPath(MultipartFile multipartFile);

	public EmployeeProfileImageProxy downloadMultiMediaDataAtDynamicPath(String fileId);

	public String uploadListofMultiMediaDataAtDynamicPath(List<MultipartFile> multipartFile);

	public ResponseEntity<byte[]> downloadListofMultiMediaDataAtDynamicPath(Long id);

//	public String saveEmployeeData(String empId, String name, String dob, String gender, String address,
//			List<MultipartFile> multipartFile);

	public String saveEmployeeData(EmployeeProxy employeeProxy, List<MultipartFile> multipartFiles);

	public String saveExcelDataIntoDatabase(MultipartFile multipartFile);

	public ByteArrayOutputStream exportToExcel();

	public String getBlankExcelFile(MultipartFile multipartFile);
}