package com.gym.management.proxy;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymProxy {

	@NotBlank(message = "Name cannot be null or empty.")
	private String member_name;

//	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate start_date;

	@NotNull(message = "Membership_Price cannot be null or empty.")
	@Range(min = 3000, message = "Minimum membership are starting from 3000.")
	private Long membership_price;

	@NotNull(message = "Age cannot be null or empty.")
	@Range(min = 19, message = "Minimum age should be 18 or more.")
	private Long member_age;

	@NotNull(message = "Mobile_No cannot be null or empty.")
	@Range(min = 1000000000l, max = 9999999999l, message = "Mobile number should be valid 10 digit number.")
	private Long member_mobile_no;

	@NotBlank(message = "Gender cannot be null or empty.")
	private String gender;
}
