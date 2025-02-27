package com.ems.filehandling.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ems.filehandling.domain.StudentResultEntity;

public interface StudentResultRepo extends JpaRepository<StudentResultEntity, Long> {

}
