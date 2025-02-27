package com.ems.security.proxy;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class EmployeeProxy {
	private Long id;

	private String username;

	private String password;

	private String gender;

	private String role;

	private String address;

	private Boolean isActive;

	private Date createdAt;

	private Date updatedAt;
}
