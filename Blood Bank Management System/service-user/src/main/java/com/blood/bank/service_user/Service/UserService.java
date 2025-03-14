package com.blood.bank.service_user.Service;

import java.util.List;

import com.blood.bank.service_user.Proxy.BloodGroupAvailbilityStatusProxy;
import com.blood.bank.service_user.Proxy.PatientBloodUtilizationHistoryProxy;
import com.blood.bank.service_user.Proxy.UserProxy;

public interface UserService {

	public String serachBloodGroupDetails(String bloodGroup);

	public String orderBloodInUnit(String bloodGroupid);

	public UserProxy getUserByUsername(String username);

	public List<UserProxy> getAllUser();

	public String deleteUserByUsername(String username);

	public UserProxy saveUser(UserProxy userproxy);

	public BloodGroupAvailbilityStatusProxy getBloodGroupDetails(String bloodGroupName);

	public String saveOrderDetails(PatientBloodUtilizationHistoryProxy bloodUtilizationHistoryProxy);

}
