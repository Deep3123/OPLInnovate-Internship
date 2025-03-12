package com.blood.bank.service_admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blood.bank.service_admin.domain.AdminEntity;
import com.blood.bank.service_admin.proxy.AdminProxy;
import com.blood.bank.service_admin.proxy.BloodBankProxy;
import com.blood.bank.service_admin.repo.AdminRepo;
import com.blood.bank.service_admin.service.AdminServices;
import com.blood.bank.service_admin.utils.MapperUtil;

@Service
public class AdminServiceImpl implements AdminServices {

	@Autowired
	private AdminRepo repo;

	@Autowired
	private RestTemplate template;

	private final String baseBBUrl = "http://SERVICE-BLOOD-BANK/blood-bank";

	@Override
	public String deleteUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBloodGroup(Long bloodgroup) {
		// TODO Auto-generated method stub
//		Map<String, Object> map = new HashMap<>();
//		map.put("bloodgroup", bloodgroup);
		return template.getForObject(baseBBUrl + "/deleteBGFromMaster/{bloodgroup}", String.class, bloodgroup);
	}

	@Override
	public List<AdminProxy> getAllAdmins() {
		// TODO Auto-generated method stub
//		System.err.println(repo.findAll());
		return MapperUtil.convertListofValue(repo.findAll(), AdminProxy.class);
	}

	@Override
	public AdminProxy getAdminByUsername(String username) {
		// TODO Auto-generated method stub
		Optional<AdminEntity> admin = repo.findByUsername(username);

		if (admin.isPresent())
			return MapperUtil.convertValue(admin.get(), AdminProxy.class);

		else
			throw new RuntimeException("User not found based on the given username.");
	}

	@Override
	public String deleteAdminByUsername(String username) {
		Optional<AdminEntity> admin = repo.findByUsername(username);

		if (admin.isPresent()) {
			repo.delete(admin.get());
			return "Admin data deleted successfully.";
		}

		else
			throw new RuntimeException("User not found based on the given username.");

	}

	@Override
	public AdminProxy registerAdmin(AdminProxy admin) {
		// TODO Auto-generated method stub
		admin.setRole("ADMIN");
		AdminEntity adminent = repo.save(MapperUtil.convertValue(admin, AdminEntity.class));
		admin.setId(adminent.getId());
		return admin;
	}

	@Override
	public String saveBloodGroupDetais(BloodBankProxy bloodBankProxy) {
		// TODO Auto-generated method stub
		return template.postForObject(baseBBUrl + "/saveBloodGroupDetais", bloodBankProxy, String.class);
	}
}
