package com.blood.bank.service_admin.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "service-blood-bank", url = "http://SERVICE-BLOOD-BANK/blood-bank")
public interface BloodBankService {

}
