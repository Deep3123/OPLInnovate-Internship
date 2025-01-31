package com.customer.management.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class Customer {
	private Integer customerId;
	private String name;
	private String email_id;
	private Long mobileNo;
	private String address;
	private String product_name;
	private Integer amount;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer customerId, String name, String email_id, Long mobileNo, String address,
			String product_name, Integer amount) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email_id = email_id;
		this.mobileNo = mobileNo;
		this.address = address;
		this.product_name = product_name;
		this.amount = amount;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email_id=" + email_id + ", mobileNo="
				+ mobileNo + ", address=" + address + ", product_name=" + product_name + ", amount=" + amount + "]";
	}
}
