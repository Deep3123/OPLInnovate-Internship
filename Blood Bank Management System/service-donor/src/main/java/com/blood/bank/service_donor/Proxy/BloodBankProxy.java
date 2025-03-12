package com.blood.bank.service_donor.Proxy;

import com.blood.bank.service_donor.enums.BloodGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodBankProxy {

	private Long id;

	private BloodGroup bbGroup;

	private String description;

	private String type;
}
