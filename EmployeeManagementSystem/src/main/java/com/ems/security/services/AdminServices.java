package com.ems.security.services;

import java.util.List;

import com.ems.security.proxy.AdminProxy;

public interface AdminServices {
	public List<AdminProxy> getAllAdminDetails();

	public AdminProxy getAdminDetailsById();

	public String saveAdminDetails(AdminProxy adminProxy);
}
