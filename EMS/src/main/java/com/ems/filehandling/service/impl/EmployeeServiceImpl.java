package com.ems.filehandling.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ems.filehandling.domain.EmployeeEntity;
import com.ems.filehandling.domain.EmployeeProfileImage;
import com.ems.filehandling.domain.StudentResultEntity;
import com.ems.filehandling.proxy.EmployeeProfileImageProxy;
import com.ems.filehandling.proxy.EmployeeProxy;
import com.ems.filehandling.proxy.ErrorData;
import com.ems.filehandling.repo.EmployeeRepo;
import com.ems.filehandling.repo.Repo;
import com.ems.filehandling.repo.StudentResultRepo;
import com.ems.filehandling.service.EmployeeServices;
import com.ems.filehandling.util.Helper;
import com.ems.filehandling.util.MapperUtil;

@Service
public class EmployeeServiceImpl implements EmployeeServices {

	@Autowired
	private Repo repo;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private StudentResultRepo stdRepo;

	@Override
	public String uploadMultiMediaData(MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		EmployeeProfileImage emp = new EmployeeProfileImage();
		emp.setFileName(multipartFile.getOriginalFilename());
		emp.setFileSize(multipartFile.getSize());
		emp.setContentType(multipartFile.getContentType());

		EmployeeEntity employee = new EmployeeEntity();
		employee.setName("Ram");
		employee.setGender("Male");
		employee.setAddress("AHD GJ IND");
		employee.setDob("15-04-2004");
		employee.setEmpId("101");
		employee = employeeRepo.save(employee);

		emp.setEmployeeEntity(employee);

		try {
			emp.setFileData(multipartFile.getBytes());
		} catch (IOException e) {
			return e.getMessage();
		}

		emp.setFileId(UUID.randomUUID().toString().concat(
				multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."))));

		repo.save(emp);
		return "Data of Multimedia saved successfully with file name: " + emp.getFileId();
	}

	@Override
	public EmployeeProfileImageProxy downloadMultiMediaData(String fileId) {
		// TODO Auto-generated method stub
		Optional<EmployeeProfileImage> file = repo.findByFileId(fileId);

		if (file.isPresent()) {
			EmployeeProfileImage employeeProfileImage = file.get();
			employeeProfileImage.getEmployeeEntity().setProfileImages(null);

			return MapperUtil.convertEntitytoProxy(employeeProfileImage);
		}
		ErrorData errorData = ErrorData.builder().errCode("404").errName("Media is not available.").build();

		return new EmployeeProfileImageProxy(errorData);
	}

	@Override
	public String uploadMultiMediaDataAtDynamicPath(MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		String filename = null;
		EmployeeProfileImage emprepo = null;
		try {
			String path = new ClassPathResource("").getFile().getAbsolutePath() + File.separator + "static"
					+ File.separator + "documents";

			System.out.println(new ClassPathResource("").getFile().getAbsolutePath());
			System.out.println("Path: " + path);

			File file = new File(path);

			if (!file.exists())
				file.mkdirs();

			filename = multipartFile.getOriginalFilename();

			String absolutePath = path + File.separator + filename;

			System.out.println("Absolute Path: " + absolutePath);

			Files.copy(multipartFile.getInputStream(), Paths.get(absolutePath), StandardCopyOption.REPLACE_EXISTING);

			EmployeeEntity employee = new EmployeeEntity();
			employee.setName("Ram");
			employee.setGender("Male");
			employee.setAddress("AHD GJ IND");
			employee.setDob("15-04-2004");
			employee.setEmpId("101");

			// Save the employee first
			employee = employeeRepo.save(employee);

			EmployeeProfileImage emp = new EmployeeProfileImage();
			emp.setFileName(filename);
			emp.setFileSize(multipartFile.getSize());
			emp.setContentType(multipartFile.getContentType());
			emp.setFileData(null);
			emp.setFileId(UUID.randomUUID().toString().concat(multipartFile.getOriginalFilename()
					.substring(multipartFile.getOriginalFilename().lastIndexOf("."))));
			emp.setEmployeeEntity(employee);

			emprepo = repo.save(emp);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Catch block executed.");
			e.printStackTrace();
		}
		return "Your media file is saved successfully with given id: "
				+ (Objects.isNull(emprepo) ? "No id found." : emprepo.getFileId());
	}

	@Override
	public EmployeeProfileImageProxy downloadMultiMediaDataAtDynamicPath(String id) {
		// TODO Auto-generated method stub
		Optional<EmployeeProfileImage> emp = repo.findByFileId(id);

		if (emp.isPresent()) {
			try {
				String path = new ClassPathResource("").getFile().getAbsolutePath() + File.separator + "static"
						+ File.separator + "documents" + File.separator + emp.get().getFileName();

				byte[] readAllBytes = Files.readAllBytes(Paths.get(path));

				emp.get().setFileData(readAllBytes);

				emp.get().getEmployeeEntity().setProfileImages(null);

				return MapperUtil.convertEntitytoProxy(emp.get());
			} catch (Exception e) {
				e.printStackTrace();

				ErrorData errorData = ErrorData.builder().errCode(HttpStatus.INTERNAL_SERVER_ERROR.toString())
						.errName(e.getMessage()).build();

				return new EmployeeProfileImageProxy(errorData);
			}
		} else {
			ErrorData errorData = ErrorData.builder().errCode("404").errName("Media is not available.").build();

			return new EmployeeProfileImageProxy(errorData);
		}
	}

//	@Override
//	public String uploadListofMultiMediaDataAtDynamicPath(List<MultipartFile> multipartFiles) {
//		StringBuilder result = new StringBuilder();
//
//		for (MultipartFile multipartFile : multipartFiles) {
//			EmployeeProfileImage emprepo = null;
//			try {
//				String path = new ClassPathResource("").getFile().getAbsolutePath() + File.separator + "static"
//						+ File.separator + "documents";
//
//				System.out.println("Path: " + path);
//
//				File file = new File(path);
//				if (!file.exists()) {
//					file.mkdirs();
//				}
//
//				String filename = multipartFile.getOriginalFilename();
//				String absolutePath = path + File.separator + filename;
//
//				System.out.println("Absolute Path: " + absolutePath);
//
//				Files.copy(multipartFile.getInputStream(), Paths.get(absolutePath),
//						StandardCopyOption.REPLACE_EXISTING);
//
//				EmployeeProfileImage emp = new EmployeeProfileImage();
//				emp.setFileName(filename);
//				emp.setFileSize(multipartFile.getSize());
//				emp.setContentType(multipartFile.getContentType());
//				emp.setFileData(null);
//				emp.setFileId(UUID.randomUUID().toString().concat(multipartFile.getOriginalFilename()
//						.substring(multipartFile.getOriginalFilename().lastIndexOf("."))));
//
//				emprepo = repo.save(emp);
//
//				result.append("Your media file with filename ").append(filename)
//						.append(" is saved successfully with ID: ").append(emprepo.getFileId()).append("\n");
//
//			} catch (Exception e) {
//				System.out.println("Catch block executed for file: " + multipartFile.getOriginalFilename());
//				e.printStackTrace();
//				result.append("Error processing file ").append(multipartFile.getOriginalFilename()).append(": ")
//						.append(e.getMessage()).append("\n");
//			}
//		}
//
//		return result.length() > 0 ? result.toString() : "No files were uploaded successfully.";
//	}

//	@Override
//	public String uploadListofMultiMediaDataAtDynamicPath(List<MultipartFile> multipartFiles) {
//		StringBuilder result = new StringBuilder();
//		EmployeeEntity employee = new EmployeeEntity();
//		employee.setName("Ram");
//		employee.setGender("Male");
//		employee.setAddress("AHD GJ IND");
//		employee.setDob("15-04-2004");
//		employee.setEmpId("101");
//
//		for (MultipartFile multipartFile : multipartFiles) {
//			EmployeeProfileImage emprepo = null;
//			try {
//				String path = new ClassPathResource("").getFile().getAbsolutePath() + File.separator + "static"
//						+ File.separator + "documents";
//
//				System.out.println("Path: " + path);
//
//				File file = new File(path);
//				if (!file.exists()) {
//					file.mkdirs();
//				}
//
//				String filename = multipartFile.getOriginalFilename();
//				String absolutePath = path + File.separator + filename;
//
//				System.out.println("Absolute Path: " + absolutePath);
//
//				Files.copy(multipartFile.getInputStream(), Paths.get(absolutePath),
//						StandardCopyOption.REPLACE_EXISTING);
//
//				EmployeeProfileImage emp = new EmployeeProfileImage();
//				emp.setFileName(filename);
//				emp.setFileSize(multipartFile.getSize());
//				emp.setContentType(multipartFile.getContentType());
//				emp.setFileData(null);
//
//				String uuid = UUID.randomUUID().toString().concat(multipartFile.getOriginalFilename()
//						.substring(multipartFile.getOriginalFilename().lastIndexOf(".")));
//
//				emp.setFileId(uuid);
//				emp.setEmployeeEntity(employee);
//				emprepo = repo.save(emp);
//
//				EmployeeUploadedFiles employeeUploadedFiles = new EmployeeUploadedFiles();
//
//				employeeUploadedFiles.setEmployeeProfileImage(emp);
//				employeeUploadedFiles.setFileId(uuid);
//
//				result.append("Your media file with filename ").append(filename)
//						.append(" is saved successfully with ID: ").append(emprepo.getFileId()).append("\n");
//
//			} catch (Exception e) {
//				System.out.println("Catch block executed for file: " + multipartFile.getOriginalFilename());
//				e.printStackTrace();
//				result.append("Error processing file ").append(multipartFile.getOriginalFilename()).append(": ")
//						.append(e.getMessage()).append("\n");
//			}
//		}
//
//		return result.length() > 0 ? result.toString() : "No files were uploaded successfully.";
//	}

	@Override
	public String uploadListofMultiMediaDataAtDynamicPath(List<MultipartFile> multipartFiles) {
		StringBuilder result = new StringBuilder();

		// Create a new employee entity (you could also fetch from DB if necessary)
		EmployeeEntity employee = new EmployeeEntity();
		employee.setName("Ram");
		employee.setGender("Male");
		employee.setAddress("AHD GJ IND");
		employee.setDob("15-04-2004");
		employee.setEmpId("101");

		// Save the employee first
		employee = employeeRepo.save(employee); // Persist the employee

		// Process each file in the multipartFiles list
		for (MultipartFile multipartFile : multipartFiles) {
			try {
				// Get the path where you want to store the files
				String path = new ClassPathResource("").getFile().getAbsolutePath() + File.separator + "static"
						+ File.separator + "documents";

				File file = new File(path);
				if (!file.exists()) {
					file.mkdirs(); // Create directories if they don't exist
				}

				String filename = multipartFile.getOriginalFilename();
				String absolutePath = path + File.separator + filename;

				Files.copy(multipartFile.getInputStream(), Paths.get(absolutePath),
						StandardCopyOption.REPLACE_EXISTING);

				// Generate fileId (UUID for uniqueness)
				String fileId = UUID.randomUUID().toString().concat(multipartFile.getOriginalFilename()
						.substring(multipartFile.getOriginalFilename().lastIndexOf(".")));

				// Create new profile image
				EmployeeProfileImage profileImage = new EmployeeProfileImage();
				profileImage.setContentType(multipartFile.getContentType());
				profileImage.setFileName(filename);
				profileImage.setFileId(fileId);
				profileImage.setFileSize(multipartFile.getSize());
				profileImage.setFileData(null); // If you want to store file data, it can go here
				profileImage.setEmployeeEntity(employee);

				// Add this profile image to the employee's profileImages list
				employee.getProfileImages().add(profileImage);

				// Save the employee (which will also persist the profile image)
				employeeRepo.save(employee);

				// Append result for each file
				result.append("Your media file with filename ").append(filename)
						.append(" is saved successfully with ID: ").append(fileId).append("\n");

			} catch (Exception e) {
				System.out.println("Catch block executed for file: " + multipartFile.getOriginalFilename());
				e.printStackTrace();
				result.append("Error processing file ").append(multipartFile.getOriginalFilename()).append(": ")
						.append(e.getMessage()).append("\n");
			}
		}

		// Return a summary of all file uploads
		return result.length() > 0 ? result.toString() : "No files were uploaded successfully.";
	}

	@Override
	public ResponseEntity<byte[]> downloadListofMultiMediaDataAtDynamicPath(Long id) {
		// Find the EmployeeProfileImages associated with the given employee ID
		List<EmployeeProfileImage> profileImagesEntity = repo.findByEmployeeEntity_Id(id);

		List<EmployeeProfileImageProxy> profileImages = MapperUtil.convertListOfEntitytoProxy(profileImagesEntity);

		if (profileImages.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		// Create ByteArrayOutputStream to hold the ZIP file contents
		ByteArrayOutputStream zipBytes = new ByteArrayOutputStream();
		ZipOutputStream zipOut = new ZipOutputStream(zipBytes);

		// Directory where files are stored (as per your upload method)
		String fileDirectory = null;
		try {
			fileDirectory = new ClassPathResource("static/documents").getFile().getAbsolutePath();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Iterate over each EmployeeProfileImage and add the image to the ZIP file
		for (EmployeeProfileImageProxy profileImage : profileImages) {
			String fileName = profileImage.getFileName();
			String filePath = fileDirectory + File.separator + fileName; // Construct the full file path

			File file = new File(filePath);
			if (file.exists()) {
				try (InputStream fileInputStream = new FileInputStream(file)) {
					// Create a new entry in the ZIP file for each profile image
					zipOut.putNextEntry(new ZipEntry(fileName));
					IOUtils.copy(fileInputStream, zipOut);
					zipOut.closeEntry();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// Close the ZIP output stream
		try {
			zipOut.finish();
			zipOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Set HTTP response headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "profile_images.zip");
		headers.setContentLength(zipBytes.size());

		// Return the ZIP file as a byte array
		return new ResponseEntity<>(zipBytes.toByteArray(), headers, HttpStatus.OK);
	}

//	@Override
//	public String saveEmployeeData(String empId, String name, String dob, String gender, String address,
//			List<MultipartFile> multipartFiles) {
//		StringBuilder result = new StringBuilder();
//
//		List<EmployeeProfileImage> profileImages = new ArrayList<>();
//
//		EmployeeEntity emp = new EmployeeEntity();
//		emp.setName(name);
//		emp.setAddress(address);
//		emp.setDob(dob);
//		emp.setGender(gender);
//		emp.setEmpId(empId);
//
//		// Process each file in the multipartFiles list
//		for (MultipartFile multipartFile : multipartFiles) {
//			try {
//				// Get the path where you want to store the files
//				String path = new ClassPathResource("").getFile().getAbsolutePath() + File.separator + "static"
//						+ File.separator + "documents";
//
//				File file = new File(path);
//				if (!file.exists()) {
//					file.mkdirs(); // Create directories if they don't exist
//				}
//
//				String filename = multipartFile.getOriginalFilename();
//				String absolutePath = path + File.separator + filename;
//
//				Files.copy(multipartFile.getInputStream(), Paths.get(absolutePath),
//						StandardCopyOption.REPLACE_EXISTING);
//
//				// Generate fileId (UUID for uniqueness)
//				String fileId = UUID.randomUUID().toString().concat(multipartFile.getOriginalFilename()
//						.substring(multipartFile.getOriginalFilename().lastIndexOf(".")));
//
//				// Create new profile image
//				EmployeeProfileImage profileImage = new EmployeeProfileImage();
//				profileImage.setContentType(multipartFile.getContentType());
//				profileImage.setFileName(filename);
//				profileImage.setFileId(fileId);
//				profileImage.setFileSize(multipartFile.getSize());
//				profileImage.setFileData(null); // If you want to store file data, it can go here
//				profileImage.setEmployeeEntity(emp);
//
//				profileImages.add(profileImage);
//
//			} catch (Exception e) {
//				System.out.println("Catch block executed for file: " + multipartFile.getOriginalFilename());
//				e.printStackTrace();
//				result.append("Error processing file ").append(multipartFile.getOriginalFilename()).append(": ")
//						.append(e.getMessage()).append("\n");
//			}
//		}
//
//		// TODO Auto-generated method stub
//
//		emp.setProfileImages(profileImages);
//
//		employeeRepo.save(emp);
//
//		result.append("Data of Employee saved successfully.");
//		return result.toString();
//	}

	@Override
	public String saveEmployeeData(EmployeeProxy employeeProxy, List<MultipartFile> multipartFiles) {
		StringBuilder result = new StringBuilder();

		List<EmployeeProfileImage> profileImages = new ArrayList<>();

		EmployeeEntity emp = MapperUtil.convertEmployeeProxytoEntity(employeeProxy);

//		emp.setName(employeeProxy.getName());
//		emp.setAddress(employeeProxy.getAddress());
//		emp.setDob(employeeProxy.getDob());
//		emp.setGender(employeeProxy.getGender());
//		emp.setEmpId(employeeProxy.getEmpId());

		// Process each file in the multipartFiles list
		for (MultipartFile multipartFile : multipartFiles) {
			try {
				// Get the path where you want to store the files
				String path = new ClassPathResource("").getFile().getAbsolutePath() + File.separator + "static"
						+ File.separator + "documents";

				File file = new File(path);
				if (!file.exists()) {
					file.mkdirs(); // Create directories if they don't exist
				}

				String filename = multipartFile.getOriginalFilename();
				String absolutePath = path + File.separator + filename;

				Files.copy(multipartFile.getInputStream(), Paths.get(absolutePath),
						StandardCopyOption.REPLACE_EXISTING);

				// Generate fileId (UUID for uniqueness)
				String fileId = UUID.randomUUID().toString().concat(multipartFile.getOriginalFilename()
						.substring(multipartFile.getOriginalFilename().lastIndexOf(".")));

				// Create new profile image
				EmployeeProfileImage profileImage = new EmployeeProfileImage();
				profileImage.setContentType(multipartFile.getContentType());
				profileImage.setFileName(filename);
				profileImage.setFileId(fileId);
				profileImage.setFileSize(multipartFile.getSize());
				profileImage.setFileData(null); // If you want to store file data, it can go here
				profileImage.setEmployeeEntity(emp);

				profileImages.add(profileImage);

			} catch (Exception e) {
				System.out.println("Catch block executed for file: " + multipartFile.getOriginalFilename());
				e.printStackTrace();
				result.append("Error processing file ").append(multipartFile.getOriginalFilename()).append(": ")
						.append(e.getMessage()).append("\n");
			}
		}

		// TODO Auto-generated method stub

		emp.setProfileImages(profileImages);

		employeeRepo.save(emp);

		result.append("Data of Employee saved successfully.");
		return result.toString();
	}

	@Override
	public String getBlankExcelFile(MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		Workbook workbook;
		try {
			workbook = new XSSFWorkbook(multipartFile.getInputStream());
			Sheet sheet = workbook.createSheet("Entities");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String saveExcelDataIntoDatabase(MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		try {
			stdRepo.saveAll(Helper.saveExcelDataIntoDatabase(multipartFile.getInputStream()));

			return "Excel data saved into database successfully.";

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Something went wrong!!!";
	}

	@Override
	public ByteArrayOutputStream exportToExcel() {
		List<StudentResultEntity> entities = stdRepo.findAll();
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Entities");

		// Create header row
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(4).setCellValue("marks");
		headerRow.createCell(5).setCellValue("passed_status");
		headerRow.createCell(0).setCellValue("id");
		headerRow.createCell(3).setCellValue("exam_date");
		headerRow.createCell(2).setCellValue("exam_name");
		headerRow.createCell(1).setCellValue("name");

		// Fill data
		int rowNum = 1;
		for (StudentResultEntity entity : entities) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(4).setCellValue(entity.getMarks());
			row.createCell(5).setCellValue(entity.isPassStatus());
			row.createCell(0).setCellValue(entity.getId());
			row.createCell(3).setCellValue(entity.getExamDate());
			row.createCell(2).setCellValue(entity.getExamName());
			row.createCell(1).setCellValue(entity.getName());
		}

		// Write to output stream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			workbook.write(outputStream);
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return outputStream;

	}
}