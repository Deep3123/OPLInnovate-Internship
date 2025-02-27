package com.sms.management.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
public class Branch {
	@Id
	@Column(name = "id")
	private Long branchId;

	@Column(name = "name")
	private String branchName;

	@Column(name = "description")
	private String branchDescription;

	@OneToOne(mappedBy = "studentBranch", cascade = CascadeType.ALL)
	private Student student;
}
