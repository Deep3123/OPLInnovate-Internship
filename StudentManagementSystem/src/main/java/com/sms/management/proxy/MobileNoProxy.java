package com.sms.management.proxy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class MobileNoProxy {
	@NotNull(message = "Mobile No cannot be null or blank.")
	private Long id;

	@NotBlank(message = "Mobile No cannot be null or blank.")
	private String mobileNo;

	@NotBlank(message = "Country Code cannot be null or blank.")
	private String countryCode;

	@NotBlank(message = "Relation field cannot be null or empty.")
	private String relation;

	private StudentProxy std;
}
