package com.customer.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import com.customer.management.pojo.Customer;

@Component
public class CustomerImplementation {
	private List<Customer> lstCustomers = new ArrayList<>();

	public String saveCustomerDetails(Customer cust) {
		if (lstCustomers.add(cust))
			return "Customer details are added successfully.";
		else
			return "There is an error to store customer details.";
	}

	public List<Customer> getAllCustomerDetails() {
		return lstCustomers;
	}

	public Customer getCustomerDetailById(Integer id) {
		return lstCustomers.stream().filter(p -> p.getCustomerId().equals(id)).findFirst().orElse(null);
	}

	public String updateCustomerDetails(Integer id, String email_id) {
		Optional<Customer> customerOpt = lstCustomers.stream().filter(p -> p.getCustomerId().equals(id)).findFirst();

		if (customerOpt.isPresent()) {
			customerOpt.get().setEmail_id(email_id);
			return "Customer details are updated successfully.";
		} else {
			return "Invalid customer id.";
		}
	}

	public String deleteCustomerDetails(Integer id) {
		Optional<Customer> customerOpt = lstCustomers.stream().filter(p -> p.getCustomerId().equals(id)).findFirst();

		if (customerOpt.isPresent()) {
			lstCustomers.remove(customerOpt.get());
			return "Customer details are deleted successfully.";
		} else {
			return "Invalid customer id.";
		}
	}

}
