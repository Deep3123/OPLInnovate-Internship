package com.hospital.management.service;

import java.util.List;
import com.hospital.management.domain.Hospital;

public interface HospitalService {
	public List<Hospital> getAllHospitalDetails();

	public Hospital getHospitalDetailById(Long id);

	public String updateHospitalDetailById(Hospital h);

	public String deleteHospitalDetailById(Long id);
	
	public String addHospitalDetails(Hospital h);
}
