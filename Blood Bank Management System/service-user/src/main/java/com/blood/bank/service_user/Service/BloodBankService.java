package com.blood.bank.service_user.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.blood.bank.service_user.Proxy.BloodGroupAvailbilityStatusProxy;
import com.blood.bank.service_user.Proxy.PatientBloodUtilizationHistoryProxy;

@FeignClient(name = "SERVICE-BLOOD-BANK")
public interface BloodBankService {
	@GetMapping("/blood-bank/getBGDetails/{bloodGroupName}")
	BloodGroupAvailbilityStatusProxy getBloodGroupDetails(@PathVariable("bloodGroupName") String bloodGroupName);

	@PostMapping("/blood-bank/saveOrderDetails")
	String saveOrderDetails(@RequestBody PatientBloodUtilizationHistoryProxy bloodUtilizationHistoryProxy);
}
