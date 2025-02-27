package com.ems.filehandling.controller;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ems.filehandling.domain.EmployeeEntity;
import com.ems.filehandling.proxy.EmployeeProfileImageProxy;
import com.ems.filehandling.proxy.EmployeeProxy;
import com.ems.filehandling.service.EmployeeServices;

import jakarta.validation.Valid;

@RestController
public class Controller {
	@Autowired
	private EmployeeServices employeeServices;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadMultiMediaData(@RequestParam("file") MultipartFile multipartFile) {
		return new ResponseEntity<>(employeeServices.uploadMultiMediaData(multipartFile), HttpStatus.OK);
	}

	@GetMapping("/download/{id}")
	public ResponseEntity<?> downloadMultiMediaData(@PathVariable("id") String id) {
		EmployeeProfileImageProxy emp = employeeServices.downloadMultiMediaData(id);
//		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(emp.getContentType()))
//				.body(emp.getFileData());
		return ResponseEntity.ok().contentType(MediaType.valueOf(emp.getContentType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + emp.getFileName() + "\"")
				.body(emp.getFileData());

	}

	@GetMapping("/view/{id}")
	public ResponseEntity<?> viewMultiMediaData(@PathVariable("id") String id) {
		EmployeeProfileImageProxy emp = employeeServices.downloadMultiMediaData(id);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(emp.getContentType()))
				.body(emp.getFileData());
	}

	@PostMapping("/upload-data-at-dynamic-path")
	public ResponseEntity<String> uploadMultiMediaDataAtDynamicPath(@RequestParam("file") MultipartFile multipartFile) {
		return new ResponseEntity<>(employeeServices.uploadMultiMediaDataAtDynamicPath(multipartFile), HttpStatus.OK);
	}

	@GetMapping("/view-data-at-dynamic-path/{id}")
	public ResponseEntity<?> viewMultiMediaDataAtDynamicPath(@PathVariable("id") String id) {
		EmployeeProfileImageProxy emp = employeeServices.downloadMultiMediaDataAtDynamicPath(id);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(emp.getContentType()))
				.body(emp.getFileData());
	}

	@PostMapping("/upload-list-of-multimedia-data-at-dynamic-path")
	public ResponseEntity<String> uploadListofMultiMediaDataAtDynamicPath(
			@RequestParam("file") List<MultipartFile> multipartFiles) {
		return new ResponseEntity<>(employeeServices.uploadListofMultiMediaDataAtDynamicPath(multipartFiles),
				HttpStatus.OK);
	}

	@GetMapping("/download-list-of-multimedia-at-dynamic-path/{id}")
	public ResponseEntity<?> downloadListofMultiMediaDataAtDynamicPath(@PathVariable("id") String id) {
		return employeeServices.downloadListofMultiMediaDataAtDynamicPath(Long.parseLong(id));
	}

	@PostMapping("/save-employee")
	public ResponseEntity<String> saveEmployeeData(@Valid @RequestPart("employee") EmployeeProxy employeeProxy,
			@RequestParam("files") List<MultipartFile> multipartFiles) {
		// Call service to handle the logic (save data to DB)
		System.out.println(employeeProxy);

		return new ResponseEntity<>(employeeServices.saveEmployeeData(employeeProxy, multipartFiles), HttpStatus.OK);
	}

	@PostMapping("/get-blank-excel-file")
	public ResponseEntity<String> getBlankExcelFile(@RequestParam("file") MultipartFile multipartFile) {
		if (multipartFile != null && (multipartFile.getContentType()
				.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
				|| multipartFile.getContentType().equals("application/vnd.ms-excel")))
			return new ResponseEntity<>(employeeServices.getBlankExcelFile(multipartFile), HttpStatus.OK);

		else
			return new ResponseEntity<>("Invalid format or excel file is missing.", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/save-excel-data-into-database")
	public ResponseEntity<String> saveExcelDataIntoDatabase(@RequestParam("file") MultipartFile multipartFile) {
		if (multipartFile != null && (multipartFile.getContentType()
				.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
				|| multipartFile.getContentType().equals("application/vnd.ms-excel")))
			return new ResponseEntity<>(employeeServices.saveExcelDataIntoDatabase(multipartFile), HttpStatus.OK);

		else
			return new ResponseEntity<>("Invalid format or excel file is missing.", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/download-excel-file")
	public ResponseEntity<byte[]> downloadExcel() {
		ByteArrayOutputStream outputStream = employeeServices.exportToExcel();
		byte[] bytes = outputStream.toByteArray();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=Student_Result_Data.xlsx");
		headers.add("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

		return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
	}
}
