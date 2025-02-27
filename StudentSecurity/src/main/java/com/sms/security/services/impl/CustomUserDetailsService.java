package com.sms.security.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sms.security.domain.User;
import com.sms.security.repo.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		User user = repo.findByUsername(username);

		if (user == null)
			throw new UsernameNotFoundException(username);

		return new CustomUserService(user);
	}
}
