package com.customer.management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.customer.management.pojo.Customer;
import com.customer.management.service.impl.CustomerImplementation;

@RestController
public class CustomerController {

	@Autowired
	private CustomerImplementation impl;

	@PostMapping("/saveCustomerDetails")
	public String saveCustomerDetails(@RequestBody Customer customer) {
		return impl.saveCustomerDetails(customer);
	}

	@PostMapping("/getAllCustomerDetails")
	public List<Customer> getAllCustomerDetails() {
		return impl.getAllCustomerDetails();
	}

	@PostMapping("/getCustomerDetailById")
	public Customer getCustomerDetailById(@RequestBody Integer id) {
		return impl.getCustomerDetailById(id);
	}

	@PostMapping("/updateCustomerDetails")
	public String updateCustomerDetails(@RequestBody Customer customer) {
		return impl.updateCustomerDetails(customer.getCustomerId(), customer.getEmail_id());
	}
	
	@PostMapping("/deleteCustomerDetails")
	public String deleteCustomerDetails(@RequestBody Integer id) {
		return impl.deleteCustomerDetails(id);
	}
}