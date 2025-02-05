package com.main.superhero.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(Include.NON_NULL)
public class SuperHero {
	@Id
	private Long id;
	private String username;
	private String name;
	private String gender;
	private String emailId;
	private String movie;
	private String address;
	private String pinCode;
	private Long mobileNo;
	private String error_msg;
	private String success_msg;
	private String status;
	
	public SuperHero(String error_msg)
	{
		this.error_msg=error_msg;
	}
	
	public SuperHero(String success_msg, String status)
	{
		this.success_msg=success_msg;
		this.status=status;
	}
}
