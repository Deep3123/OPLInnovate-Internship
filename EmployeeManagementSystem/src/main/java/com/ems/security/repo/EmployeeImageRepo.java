package com.ems.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.security.domain.EmployeeImage;

public interface EmployeeImageRepo extends JpaRepository<EmployeeImage, Long> {

	Optional<EmployeeImage> findByFileId(String id);

}
