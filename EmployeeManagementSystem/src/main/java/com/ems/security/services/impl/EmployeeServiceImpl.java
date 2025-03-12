package com.ems.security.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ems.security.domain.Employee;
import com.ems.security.domain.EmployeeImage;
import com.ems.security.proxy.EmployeeImageProxy;
import com.ems.security.proxy.EmployeeProxy;
import com.ems.security.proxy.LoginRequest;
import com.ems.security.proxy.LoginResponse;
import com.ems.security.repo.EmployeeImageRepo;
import com.ems.security.repo.EmployeeRepo;
import com.ems.security.services.EmployeeServices;
import com.ems.security.util.JwtService;
import com.ems.security.util.MapperUtil;

@Service
public class EmployeeServiceImpl implements EmployeeServices {
	@Autowired
	private EmployeeRepo emp;

	@Autowired
	private EmployeeImageRepo empImg;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private JwtService jwtService;

	@Override
	public List<EmployeeProxy> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		emp.findAll().stream().forEach(obj -> obj.getEmployeeImage()
				.setFileId("http://localhost:8080/emp/view/" + obj.getEmployeeImage().getFileId()));
		return MapperUtil.convertListofValue(emp.findAll(), EmployeeProxy.class);
	}

	@Override
	public EmployeeProxy getEmployeeDetailsById(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = emp.findById(id);

		if (employee.isPresent()) {
			employee.get().getEmployeeImage()
					.setFileId("http://localhost:8080/emp/view/" + employee.get().getEmployeeImage().getFileId());
			return MapperUtil.convertValue(employee.get(), EmployeeProxy.class);
		}
		throw new UsernameNotFoundException("User not valid.");
	}

	@Override
	public String saveEmployeeDetails(EmployeeProxy employeeProxy) {
		// TODO Auto-generated method stub
		employeeProxy.setPassword(passwordEncoder.encode(employeeProxy.getPassword()));
		emp.save(MapperUtil.convertValue(employeeProxy, Employee.class));
		return "Employee data saved successfully.";
	}

	@Override
	public LoginResponse login(LoginRequest req) {
		// TODO Auto-generated method stub
//		Optional<Employee> employee = emp.findByUsername(req.getUsername());

		System.err.println("Token");

		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(req.getUsername(),
				req.getPassword());

		Authentication authenticate = manager.authenticate(auth);

		if (authenticate.isAuthenticated())
			return new LoginResponse(req.getUsername(), jwtService.generateToken(req.getUsername()));

//		if (employee.isPresent())

		throw new UsernameNotFoundException("User not valid.");
	}

	@Override
	public String saveEmployeeDetailsWithImage(EmployeeProxy employeeProxy, MultipartFile multipartFile)
			throws IOException {
		// TODO Auto-generated method stub
		try {
			employeeProxy.setPassword(passwordEncoder.encode(employeeProxy.getPassword()));
			Employee employee = MapperUtil.convertValue(employeeProxy, Employee.class);

			String path = new ClassPathResource("").getFile().getAbsolutePath() + File.separator + "static"
					+ File.separator + "documents";

			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs(); // Create directories if they don't exist
			}

			String filename = multipartFile.getOriginalFilename();
			String absolutePath = path + File.separator + filename;

			Files.copy(multipartFile.getInputStream(), Paths.get(absolutePath), StandardCopyOption.REPLACE_EXISTING);

			// Generate fileId (UUID for uniqueness)
			String fileId = UUID.randomUUID().toString().concat(multipartFile.getOriginalFilename()
					.substring(multipartFile.getOriginalFilename().lastIndexOf(".")));

			// Create new profile image
			EmployeeImage profileImage = new EmployeeImage();
			profileImage.setContentType(multipartFile.getContentType());
			profileImage.setFileName(filename);
			profileImage.setFileId(fileId);
			profileImage.setFileSize(multipartFile.getSize());

			empImg.save(profileImage);

			employee.setEmployeeImage(profileImage);
			emp.save(employee);

			return "Employee data saved with his profile image successfully.";

		} catch (IOException e) {
			throw new IOException(e.getMessage());
		}
	}

	@Override
	public EmployeeImageProxy viewMultiMediaData(String id) {
		// TODO Auto-generated method stub
		Optional<EmployeeImage> emp = empImg.findByFileId(id);

		if (emp.isPresent()) {
			try {
				String path = new ClassPathResource("").getFile().getAbsolutePath() + File.separator + "static"
						+ File.separator + "documents" + File.separator + emp.get().getFileName();

				byte[] readAllBytes = Files.readAllBytes(Paths.get(path));

				emp.get().setFileData(readAllBytes);

				return MapperUtil.convertValue(emp.get(), EmployeeImageProxy.class);
			} catch (Exception e) {
				throw new RuntimeException("Image not found.");
			}
		} else {
			throw new UsernameNotFoundException("User details not found in database with given id.");
		}
	}

	@Override
	public Page<EmployeeProxy> getEmployeeDetailsPageWise(Integer pagenumber, Integer pagesize) {
		// TODO Auto-generated method stub
		return new PageImpl<>(
				emp.findAll(PageRequest.of(pagenumber, pagesize)).getContent().stream()
						.map(obj -> MapperUtil.convertValue(obj, EmployeeProxy.class)).collect(Collectors.toList()),
				PageRequest.of(pagenumber, pagesize),
				emp.findAll(PageRequest.of(pagenumber, pagesize)).getTotalElements());

//		return emp.findAll(PageRequest.of(pagenumber, pagesize)).map(
//				obj -> MapperUtil.convertValue(emp.findAll(PageRequest.of(pagenumber, pagesize)), EmployeeProxy.class));
	}

	@Override
	public Page<EmployeeProxy> getSortedEmployeeDetailsPageWise(Integer pagenumber, Integer pagesize, String attrname) {
		// TODO Auto-generated method stub
		return new PageImpl<>(
				emp.findAll(PageRequest.of(pagenumber, pagesize, Sort.by(Sort.Direction.DESC, attrname))).getContent()
						.stream().map(obj -> MapperUtil.convertValue(obj, EmployeeProxy.class))
						.collect(Collectors.toList()),
				PageRequest.of(pagenumber, pagesize, Sort.by(Sort.Direction.DESC, attrname)),
				emp.findAll(PageRequest.of(pagenumber, pagesize, Sort.by(Sort.Direction.DESC, attrname)))
						.getTotalElements());

//		return emp.findAll(PageRequest.of(pagenumber, pagesize, Sort.by(Sort.Direction.ASC, attrname)))
//				.map(obj -> MapperUtil.convertValue(
//						emp.findAll(PageRequest.of(pagenumber, pagesize, Sort.by(Sort.Direction.ASC, attrname))),
//						EmployeeProxy.class));
	}
}
