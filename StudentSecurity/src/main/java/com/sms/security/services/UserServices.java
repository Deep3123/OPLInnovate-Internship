package com.sms.security.services;

import java.util.List;

import com.sms.security.proxy.UserProxy;

public interface UserServices {
	public String saveUserDetails(UserProxy user);

	public List<UserProxy> getAllUserDetails();
}
