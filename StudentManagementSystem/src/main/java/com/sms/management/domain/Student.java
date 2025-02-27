package com.sms.management.domain;

import java.time.LocalDate;
import java.util.List;

import com.sms.management.enum_gender.GenderEnum;
import com.sms.management.proxy.BranchProxy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Student {
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private Long studentId;

	@Column(name = "name", length = 60)
	private String studentName;

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private GenderEnum studentGender;

	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	private LocalDate studentDob;

	@Column(name = "address")
	private String studentAddress;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "branch_id", referencedColumnName = "id")
	private Branch studentBranch;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "std")
	private List<MobileNo> mobileNo;
}
