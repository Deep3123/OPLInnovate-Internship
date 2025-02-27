package com.sms.management.global.exception;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Component
public class MissingId extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String error_name;
	private Integer error_code;
}
