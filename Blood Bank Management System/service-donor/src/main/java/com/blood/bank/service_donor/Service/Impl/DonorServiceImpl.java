package com.blood.bank.service_donor.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.blood.bank.service_donor.Domain.Donor;
import com.blood.bank.service_donor.Proxy.BloodBankProxy;
import com.blood.bank.service_donor.Proxy.BloodDonationDetailsProxy;
import com.blood.bank.service_donor.Proxy.BloodGroupAvailbilityStatusProxy;
import com.blood.bank.service_donor.Proxy.DonorProxy;
import com.blood.bank.service_donor.Repo.DonorRepo;
import com.blood.bank.service_donor.Service.DonorService;
import com.blood.bank.service_donor.Util.MapperUtil;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DonorServiceImpl implements DonorService {

	@Autowired
	private DonorRepo repo;

	@Autowired
	private RestTemplate template;

	private final String baseBBUrl = "http://SERVICE-BLOOD-BANK/blood-bank";

	@Override
	public List<String> getDonationHistoryByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String donateBlood(String anydata) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DonorProxy> getAllDonor() {
		List<Donor> donor = repo.findAll();
		// TODO Auto-generated method stub
		return MapperUtil.convertListOfValue(donor, DonorProxy.class);
	}

	@Override
	public String deleteDonorByUsername(String donorname) {
		repo.deleteByUsername(donorname);
		return "donor " + donorname + " deleted on record";

	}

	@Override
	public DonorProxy getDonorByUsername(String donorname) {
		Donor donor = repo.findByUsername(donorname)
				.orElseThrow(() -> new RuntimeException("donor details not found based on given input"));
		return MapperUtil.convertValue(donor, DonorProxy.class);
	}

//	@Override
//	public DonorProxy saveDonor(DonorProxy donorproxy) {
//		donorproxy.setRole("DONOR");
//		donorproxy.setId(null);
//
//		// Convert DonorProxy to Donor
//		Donor donor = MapperUtil.convertValue(donorproxy, Donor.class);
//
//		// Check if donor has an existing ID and version
////		if (donor.getId() != null && donor.getVersion() == null) {
////			donor.setVersion(0); // Set version to 0 to avoid detached entity issue
////		}
//
//		// Debug log before saving
//		System.out.println("Before save/merge, donor: " + donor);
//
//		// Save or merge donor to handle detached entities
//		donor = repo.save(donor); // Merge should handle detached entities
//
//		// Debug log after saving
//		System.out.println("After save/merge, donor: " + donor);
//
//		donorproxy.setId(donor.getId());
//
//		return donorproxy;
//	}

	
	@Override
	public String saveDonor(DonorProxy donorproxy) {
		donorproxy.setRole("DONOR");
		donorproxy.setId(null);

		// Convert DonorProxy to Donor
		Donor donor = MapperUtil.convertValue(donorproxy, Donor.class);

		// Check if donor has an existing ID and version
//		if (donor.getId() != null && donor.getVersion() == null) {
//			donor.setVersion(0); // Set version to 0 to avoid detached entity issue
//		}

		// Debug log before saving
		System.out.println("Before save/merge, donor: " + donor);

		// Save or merge donor to handle detached entities
		donor = repo.save(donor); // Merge should handle detached entities

		// Debug log after saving
		System.out.println("After save/merge, donor: " + donor);

		donorproxy.setId(donor.getId());

		return "success";
	}
	
	@Override
	public List<BloodBankProxy> getAllBloodBankMasterData() {
		// TODO Auto-generated method stub
		ResponseEntity<List<BloodBankProxy>> resp = template.exchange(baseBBUrl + "/getAllBloodBankMasterData",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<BloodBankProxy>>() {
				});

		System.err.println("Response-Header:- " + resp.getHeaders());
		System.err.println("Response-Body:- " + resp.getBody());
		System.err.println("Response-Status-code:- " + resp.getStatusCode());

		return resp.getBody();
	}

	@Override
	public String saveDonatedBloodGroupDetails(BloodGroupAvailbilityStatusProxy availbilityStatusProxy) {
		// Ensure the proxy is not null
		if (availbilityStatusProxy == null) {
			throw new IllegalArgumentException("BloodGroupAvailbilityStatusProxy cannot be null");
		}

		try {
			// Exchange the request
			ResponseEntity<String> resp = template.exchange(baseBBUrl + "/saveDonatedBloodGroupDetails",
					HttpMethod.POST, new HttpEntity<>(availbilityStatusProxy), // pass in the entity
					String.class);

			// Logging response details for debugging
			System.err.println("Response-Header: " + resp.getHeaders());
			System.err.println("Response-Body: " + resp.getBody());
			System.err.println("Response-Status-code: " + resp.getStatusCode());

			// Return the response body, checking for null
			return resp.getBody() != null ? resp.getBody() : "No response body";

		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			// Log the error
			System.err.println("HTTP Error occurred: " + ex.getStatusCode() + " - " + ex.getMessage());
			return "Error: " + ex.getStatusCode();
		} catch (Exception ex) {
			// Catch all other exceptions
			System.err.println("An error occurred: " + ex.getMessage());
			return "Error: " + ex.getMessage();
		}
	}

	@Override
	public List<BloodDonationDetailsProxy> getAllDonationDetails(String donorUsername) {
		// TODO Auto-generated method stub
		ResponseEntity<List<BloodDonationDetailsProxy>> resp = template.exchange(
				baseBBUrl + "/getAllDonationDetails/{donorUserName}", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<BloodDonationDetailsProxy>>() {
				}, donorUsername);

		System.err.println("Response-Header:- " + resp.getHeaders());
		System.err.println("Response-Body:- " + resp.getBody());
		System.err.println("Response-Status-code:- " + resp.getStatusCode());

		return resp.getBody();
	}

}
