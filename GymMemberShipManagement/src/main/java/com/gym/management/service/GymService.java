package com.gym.management.service;

import java.util.List;

import com.gym.management.proxy.GymProxy;

public interface GymService {
	public List<GymProxy> getAllMembersDetails();

	public GymProxy getMemberDetailsById(Long id);

	public String addMemberDetails(GymProxy g);

	public String updateMemberDetails(Long id, GymProxy g);

	public String deleteMemberDetails(Long id);
}
