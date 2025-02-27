package com.sms.management.proxy;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class BranchProxy {
	@NotNull(message = "Branch ID cannot be null or empty.")
	private Long branchId;

	@NotBlank(message = "Branch name cannot be null or empty.")
	private String branchName;

	@NotBlank(message = "Branch description cannot be null or empty.")
	@Size(max = 100, message = "Description should be under 100 characters.")
	private String branchDescription;

	private StudentProxy student;
}
