package com.sms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sms.management.proxy.BranchProxy;
import com.sms.management.service.BranchServices;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/branch")
public class BranchController {
	@Autowired
	private BranchServices branchServices;

	@PostMapping("/getAllBranch")
	public List<BranchProxy> getAllBranch() {
		return branchServices.getAllBranch();
	}

	@PostMapping("/saveBranch")
	public String saveBranch(@Valid @RequestBody BranchProxy branchProxy) {
		return branchServices.saveBranch(branchProxy);
	}

	@PostMapping("/updateBranch/{id}")
	public String updateStudent(@PathVariable("id") @NotBlank(message = "Id cannot be null or empty.") String id,
			@Valid @RequestBody BranchProxy branchProxy) {
		return branchServices.updateBranch(Long.parseLong(id), branchProxy);
	}

	@PostMapping("/deleteBranch/{id}")
	public String deleteStudent(@PathVariable("id") @NotBlank(message = "Id cannot be null or empty.") String id) {
		return branchServices.deleteBranch(Long.parseLong(id));
	}
}
