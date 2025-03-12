package com.blood.bank.service_bb.proxy;

import java.util.Date;

import com.blood.bank.service_bb.enums.BloodType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class BloodDonationDetailsProxy {

	private Long id;

	private String donorUserName;
	private String bloodGroupId;
	private String bloodGroupName;
	private Integer donatedBloodUnit;

	private String bloodType;

	private Date dateOfDonation;
	private String placeOfDonation;

}
