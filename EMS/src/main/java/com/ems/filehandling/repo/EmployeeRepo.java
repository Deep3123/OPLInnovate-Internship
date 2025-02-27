package com.ems.filehandling.repo;

import org.springframework.data.repository.CrudRepository;
import com.ems.filehandling.domain.EmployeeEntity;

public interface EmployeeRepo extends CrudRepository<EmployeeEntity, Long> {

}
