package com.ems.filehandling.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.ems.filehandling.domain.EmployeeEntity;
import com.ems.filehandling.domain.EmployeeProfileImage;

public interface Repo extends CrudRepository<EmployeeProfileImage, Long> {
	Optional<EmployeeProfileImage> findByFileId(String fileId);

	List<EmployeeProfileImage> findByEmployeeEntity_Id(Long employeeId);
}
