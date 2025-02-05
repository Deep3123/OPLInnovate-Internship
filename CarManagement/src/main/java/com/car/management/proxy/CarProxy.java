package com.car.management.proxy;

import org.hibernate.validator.constraints.Range;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class CarProxy {

	@NotNull(message = "Id cannot be null or empty.")
	private Long id;

	@NotBlank(message = "Name cannot be null or empty.")
	private String name;

	@NotNull(message = "Model_no cannot be null or empty.")
	private Long model_no;

	@NotBlank(message = "Owner name cannot be null or empty.")
	private String owner_name;

	@NotBlank(message = "Company name cannot be null or empty.")
	private String company;

	@NotNull(message = "Price cannot be null or empty.")
	private Long price;

	@NotNull(message = "Car type cannot be null or empty.")
	private String car_type;

	@NotBlank(message = "Email-Id cannot be null or empty.")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Please enter Email-Id in valid format.")
	private String owner_email_id;

	@NotNull(message = "Mobile number cannot be null or empty.")
	@Range(min = 1000000000L, max = 9999999999l, message = "Mobile number should be valid 10 digit integer value.")
	private Long owner_mobile_no;

	@NotNull(message = "Age cannot be null or empty.")
	@Min(value = 18, message = "Minimum age should be 18 or more.")
	private Long owner_age;

	@NotBlank(message = "Address cannot be null or empty.")
	private String owner_address;

	@NotBlank(message = "Pincode cannot be null or empty.")
	@Size(min = 6, max = 6, message = "Pincode should be valid 6 digit number.")
	private String owner_pinCode;

	private String msg;

	public CarProxy(String msg) {
		this.msg = msg;
	}
}
