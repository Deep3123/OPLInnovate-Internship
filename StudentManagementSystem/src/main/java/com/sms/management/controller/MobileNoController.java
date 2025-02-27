package com.sms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sms.management.proxy.MobileNoProxy;
import com.sms.management.service.MobileNoServices;

@RestController
@RequestMapping("/mobileno")
public class MobileNoController {

	@Autowired
	private MobileNoServices mobileNoServices;

	@PostMapping("/getAllMobileNoDetails")
	public List<MobileNoProxy> getAllMobileNoDetails() {
		return mobileNoServices.getAllMobileNoDetails();
	}

	@PostMapping("/saveMobileNoDetails")
	public String saveMobileNoDetails(@RequestBody MobileNoProxy mobileNoProxy) {
		return mobileNoServices.saveMobileNoDetails(mobileNoProxy);
	}

	@PostMapping("/updateMobileNoDetail/{id}")
	public String updateMobileNoDetail(@PathVariable("id") Long id, @RequestBody MobileNoProxy mobileNoProxy) {
		return mobileNoServices.updateMobileNoDetail(id, mobileNoProxy);
	}

	@PostMapping("/deleteMobileNoDetail")
	public String deleteMobileNoDetail(@PathVariable("id") Long id) {
		return mobileNoServices.deleteMobileNoDetail(id);
	}
}
