package com.gym.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gym.management.proxy.GymProxy;
import com.gym.management.service.GymService;

import jakarta.validation.Valid;

@RestController
public class GymController {

	@Autowired
	private GymService gymService;

	@PostMapping("/getAllMembersDetails")
	public List<GymProxy> getAllMembersDetails() {
		return gymService.getAllMembersDetails();
	}

	@PostMapping("/getMemberDetailsById/{id}")
	public GymProxy getMemberDetailsById(@PathVariable("id") Long id) {
		return gymService.getMemberDetailsById(id);
	}

	@PostMapping("/addMemberDetails")
	public String addMemberDetails(@Valid @RequestBody GymProxy g) {
		return gymService.addMemberDetails(g);
	}

	@PostMapping("/updateMemberDetails/{id}")
	public String updateMemberDetails(@PathVariable("id") Long id, @Valid @RequestBody GymProxy g) {
		return gymService.updateMemberDetails(id, g);
	}

	@PostMapping("/deleteMemberDetails/{id}")
	public String deleteMemberDetails(@PathVariable("id") Long id) {
		return gymService.deleteMemberDetails(id);
	}
}
