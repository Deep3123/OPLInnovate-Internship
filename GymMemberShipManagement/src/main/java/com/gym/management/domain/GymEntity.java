package com.gym.management.domain;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.gym.management.genderenum.GenderEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GymEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long member_id;

	@Column(name = "name", length = 80)
	private String member_name;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private LocalDate start_date;

	@Column(name = "membership_package")
	private Long membership_price;

	@Column(name = "age")
	private Long memberAge;

	@Column(name = "mobile_no")
	private Long member_mobile_no;

	@Enumerated(EnumType.STRING)
	private GenderEnum gender;
}
