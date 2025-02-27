package com.ems.security.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.security.proxy.AdminProxy;
import com.ems.security.repo.AdminRepo;
import com.ems.security.services.AdminServices;

@Service
public class AdminServiceImpl implements AdminServices {
	@Autowired
	private AdminRepo admin;

	@Override
	public List<AdminProxy> getAllAdminDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminProxy getAdminDetailsById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveAdminDetails(AdminProxy adminProxy) {
		// TODO Auto-generated method stub
		return null;
	}

}
