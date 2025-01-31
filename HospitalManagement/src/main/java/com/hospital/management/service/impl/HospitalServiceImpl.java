package com.hospital.management.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.management.domain.Hospital;
import com.hospital.management.repository.HospitalRepo;
import com.hospital.management.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private HospitalRepo hospitalRepo;

	@Override
	public List<Hospital> getAllHospitalDetails() {
		return hospitalRepo.findAll();
	}

	@Override
	public Hospital getHospitalDetailById(Long id) {
		return hospitalRepo.findById(id).get();
	}

	@Override
	public String updateHospitalDetailById(Hospital h) {
	    Hospital hospital = hospitalRepo.findById(h.getHosp_id()).orElse(null);
	    if (hospital != null) {
	        hospital.setCapacity(h.getCapacity());
	        hospitalRepo.save(hospital); // Save the updated hospital details
	        return "Hospital data updated successfully.";
	    } else {
	        return "Hospital not found.";
	    }
	}


	@Override
	public String deleteHospitalDetailById(Long id) {
		hospitalRepo.deleteById(id);
		return "Hospital data deleted successfully.";
	}

	@Override
	public String addHospitalDetails(Hospital h) {
		hospitalRepo.save(h);
		return "Hospital data saved successfully.";
	}

}
