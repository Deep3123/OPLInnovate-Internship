package com.sms.management.proxy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sms.management.domain.Branch;
import com.sms.management.enum_gender.GenderEnum;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class StudentProxy {

	@NotNull(message = "Student ID cannot be null or empty.")
	private Long studentId;

	@NotBlank(message = "Student name cannot be null or empty.")
	private String studentName;

//	@NotBlank(message = "Student gender cannot be null or empty.")
	private GenderEnum studentGender;

	private LocalDate studentDob;

	@NotBlank(message = "Student address cannot be null or empty.")
	private String studentAddress;

//	@NotBlank(message = "Student branch cannot be null or empty.")
	private BranchProxy studentBranch;

	private List<MobileNoProxy> mobileNo=new ArrayList<>();
	
}
