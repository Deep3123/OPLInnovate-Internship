package com.hospital.management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hospital.management.domain.Hospital;
import com.hospital.management.service.HospitalService;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@PostMapping("/getAllHospitalDetails")
	public List<Hospital> getAllHospitalDetails() {
		return hospitalService.getAllHospitalDetails();
	}

	@PostMapping("/getHospitalDetailById/{id}")
	public Hospital getHospitalDetailById(@PathVariable("id") Long id) {
		return hospitalService.getHospitalDetailById(id);
	}

	@PostMapping("/updateHospitalDetailById")
	public String updateHospitalDetailById(@RequestBody Hospital h) {
		return hospitalService.updateHospitalDetailById(h);
	}

	@PostMapping("/deleteHospitalDetailById/{id}")
	public String deleteHospitalDetailById(@PathVariable("id") Long id) {
		return hospitalService.deleteHospitalDetailById(id);
	}
	
	@PostMapping("/addHospitalDetails")
	public String addHospitalDetails(@RequestBody Hospital h) {
		return hospitalService.addHospitalDetails(h);
	}
}
