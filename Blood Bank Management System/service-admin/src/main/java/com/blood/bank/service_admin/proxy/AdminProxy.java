package com.blood.bank.service_admin.proxy;

import com.blood.bank.service_admin.domain.AdminEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminProxy {
	private Long id;

	private String name;

	private String gender;

	private String username;

	private String password;

	private String role;

	private Boolean isActive;
}
