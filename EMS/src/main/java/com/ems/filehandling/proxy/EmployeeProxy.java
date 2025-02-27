package com.ems.filehandling.proxy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class EmployeeProxy {
	private Long id;
	private String empId;
	private String name;
	private String dob;
	private String gender;
	private String address;
	private EmployeeProfileImageProxy employeeProfileImageProxy;
}
