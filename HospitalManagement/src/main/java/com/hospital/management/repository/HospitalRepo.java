package com.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hospital.management.domain.Hospital;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital, Long>{
	
}
