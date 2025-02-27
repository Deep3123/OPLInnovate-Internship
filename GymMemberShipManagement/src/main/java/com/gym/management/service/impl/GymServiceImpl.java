package com.gym.management.service.impl;

import java.util.List;
import java.util.stream.Collectors;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gym.management.domain.GymEntity;
import com.gym.management.enum_errors.ExceptionHandlerEnum;
import com.gym.management.exception.ListEmptyException;
import com.gym.management.exception.MissingId;
import com.gym.management.proxy.GymProxy;
import com.gym.management.repository.GymRepo;
import com.gym.management.service.GymService;

@Service
public class GymServiceImpl implements GymService {

	@Autowired
	private GymRepo gymRepo;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<GymProxy> getAllMembersDetails() {
		// TODO Auto-generated method stub
		if (!gymRepo.findAll().isEmpty() && gymRepo.findAll() != null) {
			return gymRepo.findAll().stream().map(obj -> objectMapper.convertValue(obj, GymProxy.class))
					.collect(Collectors.toList());
		} else {
			throw new ListEmptyException(ExceptionHandlerEnum.NOT_NULL.getErrName(),
					ExceptionHandlerEnum.NOT_NULL.getErrCode());
		}
	}

	@Override
	public GymProxy getMemberDetailsById(Long id) {
		// TODO Auto-generated method stub
		GymEntity gymEntity = gymRepo.findById(id).get();
		return objectMapper.convertValue(gymEntity, GymProxy.class);
	}

	@Override
	public String addMemberDetails(GymProxy g) {
		// TODO Auto-generated method stub
		gymRepo.save(objectMapper.convertValue(g, GymEntity.class));
		return "Data of MemberShip is saved successfully.";

	}

	@Override
	public String updateMemberDetails(Long id, GymProxy g) {
		// TODO Auto-generated method stub
		if (id != null && gymRepo.findById(id).isPresent()) {
			gymRepo.save(objectMapper.convertValue(g, GymEntity.class));
			return "Data of membership is updated successfully.";
		} else {
			throw new MissingId(
					"Id is either missing in request or database does not contain any data related with this id.", 404);
		}
	}

	@Override
	public String deleteMemberDetails(Long id) {
		// TODO Auto-generated method stub
		if (id != null && gymRepo.findById(id).isPresent()) {
			gymRepo.deleteById(id);
			return "Data of membership is deleted successfully.";
		} else {
			throw new MissingId(
					"Id is either missing in request or database does not contain any data related with this id.", 404);
		}
	}
}
