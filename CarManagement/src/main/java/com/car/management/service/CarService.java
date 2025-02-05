package com.car.management.service;

import java.util.List;

import com.car.management.proxy.CarProxy;

public interface CarService {
	public List<CarProxy> getAllCarDetails();
	
	public CarProxy getCarDetailsById(Long id);
	
	public String saveCarDetails(CarProxy c);
	
	public String updateCarDetails(CarProxy c);
	
	public String deleteCarDetails(Long id);
}
