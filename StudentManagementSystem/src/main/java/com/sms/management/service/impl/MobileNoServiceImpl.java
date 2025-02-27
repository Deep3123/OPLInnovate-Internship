package com.sms.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sms.management.domain.MobileNo;
import com.sms.management.global.exception.ListEmptyException;
import com.sms.management.global.exception.MissingId;
import com.sms.management.proxy.MobileNoProxy;
import com.sms.management.repo.MobileNoRepo;
import com.sms.management.service.MobileNoServices;
import com.sms.management.util.MapperUtils;

@Service
public class MobileNoServiceImpl implements MobileNoServices {

	@Autowired
	private MobileNoRepo mobileNoRepo;

	@Autowired
	private MapperUtils mapperUtils;

	@Override
	public List<MobileNoProxy> getAllMobileNoDetails() {
		if (!mobileNoRepo.findAll().isEmpty() && !mobileNoRepo.findAll().equals(null)) {
			return mapperUtils.ListofMobileNoEntitytoMobileNoProxy(mobileNoRepo.findAll());
		} else {
			throw new ListEmptyException("No data to display currently.", 404);
		}
	}

	@Override
	public String saveMobileNoDetails(MobileNoProxy mobileNoProxy) {
		// TODO Auto-generated method stub
		MobileNo mobileNo = mapperUtils.MobileNoProxytoMobileNoEntity(mobileNoProxy);
		mobileNo.getStd().setMobileNo(null);
		mobileNoRepo.save(mobileNo);
		return "Data of Mobile_number saved successfully.";
	}

	@Override
	public String updateMobileNoDetail(Long id, MobileNoProxy mobileNoProxy) {
		// TODO Auto-generated method stub
		Optional<MobileNo> mb = mobileNoRepo.findById(id);
		if (mb.isPresent()) {
			MobileNo mobileNo = mb.get();

			if (mobileNoProxy.getId() != null)
				mobileNo.setId(mobileNoProxy.getId());

			if (mobileNoProxy.getCountryCode() != null)
				mobileNo.setCountryCode(mobileNoProxy.getCountryCode());

			if (mobileNoProxy.getRelation() != null)
				mobileNo.setRelation(mobileNoProxy.getRelation());

			if (mobileNoProxy.getStd() != null) {
				mobileNo.getStd().setStudentId(mobileNoProxy.getStd().getStudentId());
				mobileNo.getStd().setStudentAddress(mobileNoProxy.getStd().getStudentAddress());
				mobileNo.getStd().setStudentDob(mobileNoProxy.getStd().getStudentDob());
				mobileNo.getStd().setStudentGender(mobileNoProxy.getStd().getStudentGender());
				mobileNo.getStd().setStudentName(mobileNoProxy.getStd().getStudentName());
				mobileNo.getStd().setStudentBranch(
						mapperUtils.BranchProxytoBranchEntity(mobileNoProxy.getStd().getStudentBranch()));
			}

			mobileNoRepo.save(mobileNo);

			return "Data of branch updated successfully.";
		} else {
			throw new MissingId("Either id is missing in database or id is invalid.", 400);
		}
	}

	@Override
	public String deleteMobileNoDetail(Long id) {
		// TODO Auto-generated method stub
		if (id != null && mobileNoRepo.findById(id).isPresent()) {
			mobileNoRepo.deleteById(id);
			return "Data of Mobile_number deleted successfully.";
		} else {
			throw new MissingId("Id missing in database or invalid id.", 400);
		}
	}

}
