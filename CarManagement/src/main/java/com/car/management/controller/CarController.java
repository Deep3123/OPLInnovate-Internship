package com.car.management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.management.proxy.CarProxy;
import com.car.management.service.CarService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping("/getAllCarDetails")
	public List<CarProxy> getAllCarDetails() {
		return carService.getAllCarDetails();
	}

	@PostMapping("/getCarDetailsById/{id}")
	public CarProxy getCarDetailsById(@PathVariable("id") @NotNull(message = "Id cannot be null or empty.") Long id) {
		return carService.getCarDetailsById(id);
	}

	@PostMapping("/updateCarDetails")
	public CarProxy updateCarDetails(@Valid @RequestBody CarProxy c) {
		return new CarProxy(carService.updateCarDetails(c));
	}

	@PostMapping("/deleteCarDetails/{id}")
	public CarProxy deleteCarDetails(@Valid @PathVariable("id") Long id) {
		return new CarProxy(carService.deleteCarDetails(id));
	}

	@PostMapping("/saveCarDetails")
	public CarProxy saveCarDetails(@Valid @RequestBody CarProxy c) {
		return new CarProxy(carService.saveCarDetails(c));
	}
}
