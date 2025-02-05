package com.car.management.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.car.management.domain.CarEntity;
import com.car.management.exception.globalexception.ListEmptyException;
import com.car.management.exception.globalexception.MissingId;
import com.car.management.proxy.CarProxy;
import com.car.management.repository.CarRepo;
import com.car.management.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepo carRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<CarProxy> getAllCarDetails() {
		// TODO Auto-generated method
		if (carRepo.findAll().isEmpty())
			throw new ListEmptyException("Sorry, No data available in database", 404);
		else
			return carRepo.findAll().stream().map(p -> mapper.map(p, CarProxy.class)).collect(Collectors.toList());
	}

	@Override
	public CarProxy getCarDetailsById(Long id) {
		// TODO Auto-generated method stub
//		if (carRepo.findById(id).isPresent()) {
		CarEntity carEntity = carRepo.findById(id).get();
		return mapper.map(carEntity, CarProxy.class);
//		} else {
//			return new CarProxy("Details of car not found in database.");
//		}
	}

	@Override
	public String saveCarDetails(CarProxy c) {
		// TODO Auto-generated method stub
		carRepo.save(mapper.map(c, CarEntity.class));
		return "Details of car has been saved successfully.";
	}

	@Override
	public String updateCarDetails(CarProxy c) {
		// TODO Auto-generated method stub
		CarEntity carEntity = mapper.map(c, CarEntity.class);

		if (carRepo.findById(carEntity.getId()).isPresent()) {
			if (carEntity.getName() != null)
				carEntity.setName(carEntity.getName());

			if (carEntity.getCar_type() != null)
				carEntity.setCar_type(carEntity.getCar_type());

			if (carEntity.getCompany() != null)
				carEntity.setCompany(carEntity.getCompany());

			if (carEntity.getOwner_name() != null)
				carEntity.setOwner_name(carEntity.getOwner_name());

			if (carEntity.getModel_no() != null)
				carEntity.setModel_no(carEntity.getModel_no());

			carRepo.save(carEntity);

			return "Details of car has been updated successfully.";
		} else {
//			return "Details of car not found in database.";
			throw new MissingId("Details of car not found in database.", 404);
		}
	}

	@Override
	public String deleteCarDetails(Long id) {
		// TODO Auto-generated method stub
		if (carRepo.findById(id).isPresent()) {
			carRepo.deleteById(id);
			return "Details of car has been deleted successfully.";
		} else {
			throw new MissingId("Details of car not found in database.", 404);
		}
	}

}
