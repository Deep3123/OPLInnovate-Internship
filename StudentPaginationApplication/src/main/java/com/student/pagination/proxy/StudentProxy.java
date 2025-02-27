package com.student.pagination.proxy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class StudentProxy {
	private Long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNo;
	private String address;
	private String pinCode;

	public StudentProxy(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
