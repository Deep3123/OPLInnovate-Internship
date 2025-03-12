package com.blood.bank.service_admin.controller;

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

import com.blood.bank.service_admin.proxy.AdminProxy;
import com.blood.bank.service_admin.proxy.BloodBankProxy;
import com.blood.bank.service_admin.service.AdminServices;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminServices service;

	@GetMapping("/deleteUser/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable String username) {
		return new ResponseEntity<>(service.deleteUser(username), HttpStatus.OK);
	}

	@GetMapping("/deleteBloodGroup/{bloodgroup}")
	public ResponseEntity<String> deleteBloodGroup(@PathVariable Long bloodgroup) {
		return new ResponseEntity<>(service.deleteBloodGroup(bloodgroup), HttpStatus.OK);
	}

	@GetMapping("/getAllAdmins")
	public ResponseEntity<List<AdminProxy>> getAllAdmins() {
		return new ResponseEntity<>(service.getAllAdmins(), HttpStatus.OK);
	}

	@GetMapping("/getAdmin/{username}")
	public ResponseEntity<AdminProxy> getAdminByUsername(@PathVariable String username) {
		return new ResponseEntity<>(service.getAdminByUsername(username), HttpStatus.OK);
	}

	@GetMapping("/deleteAdminByUsername/{username}")
	public ResponseEntity<String> deleteAdminByUsername(@PathVariable String username) {
		return new ResponseEntity<>(service.deleteAdminByUsername(username), HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<AdminProxy> registerAdmin(@RequestBody AdminProxy admin) {
		return new ResponseEntity<>(service.registerAdmin(admin), HttpStatus.CREATED);
	}

	@PostMapping("/saveBloodGroupDetais")
	public ResponseEntity<String> saveBloodGroupDetais(@RequestBody BloodBankProxy bloodBankProxy) {
		return new ResponseEntity<>(service.saveBloodGroupDetais(bloodBankProxy), HttpStatus.CREATED);
	}
}
