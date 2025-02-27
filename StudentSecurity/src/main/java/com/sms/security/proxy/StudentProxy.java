package com.sms.security.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProxy {
	private Long id;
	private String name;
	private String emailId;
	private String branch;
	private String mobileNo;
}
