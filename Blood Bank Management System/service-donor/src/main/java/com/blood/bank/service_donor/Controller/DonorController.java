package com.blood.bank.service_donor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blood.bank.service_donor.Proxy.BloodBankProxy;
import com.blood.bank.service_donor.Proxy.BloodDonationDetailsProxy;
import com.blood.bank.service_donor.Proxy.BloodGroupAvailbilityStatusProxy;
import com.blood.bank.service_donor.Proxy.DonorProxy;
import com.blood.bank.service_donor.Service.DonorService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/Donor")
public class DonorController {

	@Autowired
	private DonorService donorService;

//public List<String> getDonationHistoryByUsername(String username);
	@PostMapping("/get-Donation-History/{donorname}")
	public ResponseEntity<List<String>> getDonationHistoryByUsername(
			@PathVariable(value = "donorname") String donorname) {
		return new ResponseEntity<List<String>>(donorService.getDonationHistoryByUsername(donorname), HttpStatus.OK);
	}

//	public String donateBlood(String anydata);
	@PostMapping("/donate-blood/{blooddata}")
	public ResponseEntity<String> donateBlood(@PathVariable(value = "blooddata") String blooddata) {
		return new ResponseEntity<String>(donorService.donateBlood(blooddata), HttpStatus.OK);
	}

//	public String deleteDonorByUsername(String username);
	@Transactional
	@GetMapping("/deleteDonorByName/{donorname}")
	public ResponseEntity<String> deleteDelete(@PathVariable(value = "donorname") String donorname) {
		return new ResponseEntity<String>(donorService.deleteDonorByUsername(donorname), HttpStatus.OK);
	}

//	
//	public List<DonorProxy> getAllDonor();
	@GetMapping("/getAllDonor")
	public ResponseEntity<List<DonorProxy>> getAllDonor() {
		return new ResponseEntity<List<DonorProxy>>(donorService.getAllDonor(), HttpStatus.OK);
	}

//
//	public DonorProxy getDonorByUsername(String username);
	@GetMapping("/getDonorByName/{donorname}")
	public ResponseEntity<DonorProxy> getDonor(@PathVariable(value = "donorname") String donorname) {
		return new ResponseEntity<DonorProxy>(donorService.getDonorByUsername(donorname), HttpStatus.OK);
	}

//	
//
//
//	public DonorProxy saveDonor(DonorProxy donorproxy);
	@PostMapping("/saveDonor")
	public ResponseEntity<?> saveDonor(@RequestBody DonorProxy donorProxy) {
		return new ResponseEntity<>(donorService.saveDonor(donorProxy), HttpStatus.CREATED);
	}

	@GetMapping("/getAllBloodBankMasterData")
	public ResponseEntity<List<BloodBankProxy>> getAllBloodBankMasterData() {
		return new ResponseEntity<>(donorService.getAllBloodBankMasterData(), HttpStatus.OK);
	}

	@PostMapping("/saveDonatedBloodGroupDetails")
	public ResponseEntity<String> saveDonatedBloodGroupDetails(
			@RequestBody BloodGroupAvailbilityStatusProxy availbilityStatusProxy) {
		return new ResponseEntity<String>(donorService.saveDonatedBloodGroupDetails(availbilityStatusProxy),
				HttpStatus.CREATED);
	}

	@GetMapping("/getAllDonationDetails/{donorUserName}")
	public ResponseEntity<List<BloodDonationDetailsProxy>> getAllDonationDetails(@PathVariable String donorUserName) {
		return new ResponseEntity<>(donorService.getAllDonationDetails(donorUserName), HttpStatus.OK);
	}
}
