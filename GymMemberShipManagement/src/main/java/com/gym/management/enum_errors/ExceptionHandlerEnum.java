package com.gym.management.enum_errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionHandlerEnum {
	NOT_NULL("Value cannot be null.", 400), NOT_FOUND("Value not found either in database or request.", 404);

	private String errName;
	private Integer errCode;
}
