package com.hospital.management.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hospital {
	@Id
	private Long hosp_id;
	private String name;
	private String capacity;
	private String address;
	private Integer pincode;
}
