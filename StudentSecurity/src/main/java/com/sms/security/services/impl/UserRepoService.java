package com.sms.security.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.security.domain.User;
import com.sms.security.proxy.UserProxy;
import com.sms.security.repo.UserRepo;
import com.sms.security.services.UserServices;

@Service
public class UserRepoService implements UserServices {
	@Autowired
	private UserRepo repo;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public String saveUserDetails(UserProxy userproxy) {
		userproxy.setPassword(passwordEncoder.encode(userproxy.getPassword()));
		repo.save(mapper.convertValue(userproxy, User.class));
		return "User details saved successfully.";
	}

	@Override
	public List<UserProxy> getAllUserDetails() {
		// TODO Auto-generated method stub
		return repo.findAll().stream().map(obj -> mapper.convertValue(obj, UserProxy.class))
				.collect(Collectors.toList());
	}
}
