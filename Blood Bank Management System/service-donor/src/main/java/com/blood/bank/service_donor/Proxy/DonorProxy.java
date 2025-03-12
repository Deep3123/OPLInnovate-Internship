package com.blood.bank.service_donor.Proxy;

import com.blood.bank.service_donor.Domain.Donor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonorProxy {
	private Long id;
	private String name;
	private String gender;
	private String username;
	private String password;
	private String role ;
	private Boolean isActive;
}
