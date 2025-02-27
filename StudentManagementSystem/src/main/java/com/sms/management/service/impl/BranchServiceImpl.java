package com.sms.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.management.domain.Branch;
import com.sms.management.domain.Student;
import com.sms.management.global.exception.ListEmptyException;
import com.sms.management.global.exception.MissingId;
import com.sms.management.proxy.BranchProxy;
import com.sms.management.proxy.StudentProxy;
import com.sms.management.repo.BranchRepo;
import com.sms.management.repo.StudentRepo;
import com.sms.management.service.BranchServices;
import com.sms.management.util.MapperUtils;

@Service
public class BranchServiceImpl implements BranchServices {

	@Autowired
	private BranchRepo branchRepo;

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private MapperUtils mapperUtils;

	@Override
	public List<BranchProxy> getAllBranch() {
		// TODO Auto-generated method stub
		if (!branchRepo.findAll().isEmpty() && !branchRepo.findAll().equals(null)) {
			return mapperUtils.ListofBranchEntitytoBranchProxy(branchRepo.findAll());
		} else {
			throw new ListEmptyException("No data to display currently.", 404);
//			return null;
		}

//		List<Branch> branch = branchRepo.findAll();
//
//		List<BranchProxy> branchProxies = new ArrayList<>();
//
//		for (Branch br : branch) {
//			br.getStudent().setStudentBranch(null);
////			System.out.println(br.getBranchId());
////			System.out.println(br.getBranchName());
////			System.out.println(br.getBranchDescription());	
////			System.out.println(br.getStudent().getStudentBranch());
//			branchProxies.add(mapperUtils.BranchEntitytoBranchProxy(br));
//		}
//		return branchProxies;
	}

	@Override
	public String saveBranch(BranchProxy branchProxy) {
		// TODO Auto-generated method stub
//		Student student = new Student();

//		StudentProxy student = new StudentProxy();
//		
//		// Check if the ID is valid before setting it
//		if (branchProxy.getStudent().getStudentId() != null) {
//			student.setStudentId(branchProxy.getStudent().getStudentId()); // Ensure valid ID
//		} else {
//			student.setStudentId(null); // Handle the case where ID is not available, if needed
//		}
//
//		student.setStudentAddress(branchProxy.getStudent().getStudentAddress());
//		student.setStudentName(branchProxy.getStudent().getStudentName());
//		student.setStudentGender(branchProxy.getStudent().getStudentGender());
//		student.setStudentDob(branchProxy.getStudent().getStudentDob());
//		student.setStudentBranch(branchProxy);
//		branchProxy.getStudent().setStudentBranch(branchProxy);
//		studentRepo.save(mapperUtils.StudentProxytoStudentEntity(branchProxy.getStudent()));

		Branch branch = mapperUtils.BranchProxytoBranchEntity(branchProxy);
		branch.getStudent().setStudentBranch(branch);

		Student student = branch.getStudent();
		student.getMobileNo().stream().forEach(obj -> obj.setStd(student));

		branchRepo.save(branch);

		return "Data of branch saved successfully.";
	}

	@Override
	public String updateBranch(Long id, BranchProxy branchProxy) {
		// TODO Auto-generated method stub
		Optional<Branch> br = branchRepo.findById(id);
		if (br.isPresent()) {
			Branch branch = br.get();

			if (branchProxy.getBranchId() != null)
				branch.setBranchId(branchProxy.getBranchId());

			if (branchProxy.getBranchDescription() != null)
				branch.setBranchDescription(branchProxy.getBranchDescription());

			if (branchProxy.getBranchName() != null)
				branch.setBranchName(branchProxy.getBranchName());

			if (branchProxy.getStudent() != null) {
				branch.getStudent().setStudentId(branchProxy.getStudent().getStudentId());
				branch.getStudent().setStudentAddress(branchProxy.getStudent().getStudentAddress());
				branch.getStudent().setStudentDob(branchProxy.getStudent().getStudentDob());
				branch.getStudent().setStudentGender(branchProxy.getStudent().getStudentGender());
				branch.getStudent().setStudentName(branchProxy.getStudent().getStudentName());
				branch.getStudent().setMobileNo(
						mapperUtils.ListofMobileNoProxytoMobileNoEntity(branchProxy.getStudent().getMobileNo()));
				branch.getStudent().setStudentBranch(branch);
			}

			Student student = branch.getStudent();
			student.getMobileNo().stream().forEach(obj -> obj.setStd(student));

			branchRepo.save(branch);

			return "Data of branch updated successfully.";
		} else {
			throw new MissingId("Either id is missing in database or id is invalid.", 400);
		}

//		Branch branch = branchRepo.findById(id).get();
//		branch.getStudent().setStudentBranch(null);
//		mapperUtils.BranchEntitytoBranchProxy(branch);
//
//		return "Data of branch updated successfully.";
	}

	@Override
	public String deleteBranch(Long id) {
		// TODO Auto-generated method stub
		if (id != null && branchRepo.findById(id).isPresent()) {
			branchRepo.deleteById(id);
			return "Data of branch deleted successfully.";
		} else {
			throw new MissingId("Id missing in database or invalid id.", 400);
		}
	}

}
