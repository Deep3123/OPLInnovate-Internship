package com.blood.bank.service_bb.proxy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class BloodGroupAvailbilityStatusProxy {

	private Long id;

	private String bloodGroupId;
	private String bloodGroupName;
	private Integer availabBloodInUnit;

	private List<BloodDonationDetailsProxy> donationDetails;
}
