package com.blood.bank.service_user.Proxy;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodGroupAvailbilityStatusProxy {

	private Long id;

	private String bloodGroupId;
	private String bloodGroupName;
	private Integer availabBloodInUnit;

	private List<BloodDonationDetailsProxy> donationDetails;
}
