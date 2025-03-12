package com.blood.bank.service_user.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blood.bank.service_user.Domain.User;
import com.blood.bank.service_user.Proxy.BloodGroupAvailbilityStatusProxy;
import com.blood.bank.service_user.Proxy.PatientBloodUtilizationHistoryProxy;
import com.blood.bank.service_user.Proxy.UserProxy;
import com.blood.bank.service_user.Repo.UserRepo;
import com.blood.bank.service_user.Service.BloodBankService;
import com.blood.bank.service_user.Service.UserService;
import com.blood.bank.service_user.Utils.MapperUtil;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;

//	@Autowired
//	private RestTemplate template;

//	private final String baseBBUrl = "http://SERVICE-BLOOD-BANK/blood-bank";

	@Autowired
	private BloodBankService service;

	@Override
	public String serachBloodGroupDetails(String bloodGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String orderBloodInUnit(String bloodGroupid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProxy getUserByUsername(String username) {
		// TODO Auto-generated method stub

		User user = repo.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("user details not found based on given input"));
		return MapperUtil.convertValue(user, UserProxy.class);
	}

	@Override
	public List<UserProxy> getAllUser() {
		List<User> findAll = repo.findAll();
		// TODO Auto-generated method stub
		return MapperUtil.convertListOfValue(findAll, UserProxy.class);
	}

	@Override
	@Transactional
	public String deleteUserByUsername(String username) {
		repo.deleteByUsername(username);
		return "user " + username + " deleted on record";
	}

	@Override
	public UserProxy saveUser(UserProxy userproxy) {
		// TODO Auto-generated method stub
		userproxy.setRole("User");
		User user = repo.save(MapperUtil.convertValue(userproxy, User.class));
		userproxy.setId(user.getId());
		return userproxy;
	}

	@Override
	public BloodGroupAvailbilityStatusProxy getBloodGroupDetails(String bloodGroupName) {
		// TODO Auto-generated method stub

//		ResponseEntity<BloodGroupAvailbilityStatusProxy> resp = template.getForEntity(
//				baseBBUrl + "/getBGDetails/{bgName}", BloodGroupAvailbilityStatusProxy.class, bloodGroupName);
//
//		System.err.println("Response-Header:- " + resp.getHeaders());
//		System.err.println("Response-Body:- " + resp.getBody());
//		System.err.println("Response-Status-code:- " + resp.getStatusCode());
//
//		return resp.getBody();

		return service.getBloodGroupDetails(bloodGroupName);
	}

	@Override
	public String saveOrderDetails(PatientBloodUtilizationHistoryProxy bloodUtilizationHistoryProxy) {
		// TODO Auto-generated method stub
//		ResponseEntity<String> resp = template.postForEntity(baseBBUrl + "/saveOrderDetails",
//				bloodUtilizationHistoryProxy, String.class);
//
//		System.err.println("Response-Header:- " + resp.getHeaders());
//		System.err.println("Response-Body:- " + resp.getBody());
//		System.err.println("Response-Status-code:- " + resp.getStatusCode());
//
//		return resp.getBody();

		return service.saveOrderDetails(bloodUtilizationHistoryProxy);
	}

}
