package com.blood.bank.service_donor.Service;

import java.util.List;

import com.blood.bank.service_donor.Proxy.BloodBankProxy;
import com.blood.bank.service_donor.Proxy.BloodDonationDetailsProxy;
import com.blood.bank.service_donor.Proxy.BloodGroupAvailbilityStatusProxy;
import com.blood.bank.service_donor.Proxy.DonorProxy;

public interface DonorService {

	public List<String> getDonationHistoryByUsername(String username);

	public String donateBlood(String anydata);

	public List<DonorProxy> getAllDonor();

	public String deleteDonorByUsername(String username);

	public DonorProxy getDonorByUsername(String username);

//	public DonorProxy saveDonor(DonorProxy donorproxy);

	public String saveDonor(DonorProxy donorproxy);

	public List<BloodBankProxy> getAllBloodBankMasterData();// Master

	public String saveDonatedBloodGroupDetails(BloodGroupAvailbilityStatusProxy availbilityStatusProxy);

	public List<BloodDonationDetailsProxy> getAllDonationDetails(String donorUsername);
}
