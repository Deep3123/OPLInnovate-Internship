package com.blood.bank.service_admin.service;

import java.util.List;

import com.blood.bank.service_admin.proxy.AdminProxy;
import com.blood.bank.service_admin.proxy.BloodBankProxy;

public interface AdminServices {
	public String deleteUser(String username);

	public String deleteBloodGroup(Long bloodgroup);

	public List<AdminProxy> getAllAdmins();

	public AdminProxy getAdminByUsername(String username);

	public String deleteAdminByUsername(String username);

	public AdminProxy registerAdmin(AdminProxy admin);

	public String saveBloodGroupDetais(BloodBankProxy bloodBankProxy);
}
