package com.sms.management.service;

import java.util.List;
import com.sms.management.proxy.MobileNoProxy;

public interface MobileNoServices {
	public List<MobileNoProxy> getAllMobileNoDetails();

	public String saveMobileNoDetails(MobileNoProxy mobileNoProxy);

	public String updateMobileNoDetail(Long id, MobileNoProxy mobileNoProxy);

	public String deleteMobileNoDetail(Long id);
}
