package com.sms.management.service;

import java.util.List;
import com.sms.management.proxy.BranchProxy;

public interface BranchServices {
	public List<BranchProxy> getAllBranch();

	public String saveBranch(BranchProxy branchProxy);

	public String updateBranch(Long id, BranchProxy branchProxy);

	public String deleteBranch(Long id);
}