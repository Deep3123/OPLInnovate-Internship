package com.car.management.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {
	@Id
	private Long id;
	private String name;
	private Long model_no;
	private String owner_name;
	private String company;
	private Long price;
	private String car_type;
	private String owner_email_id;
	private Long owner_mobile_no;
	private Long owner_age;
	private String owner_address;
	private String owner_pinCode;
}
