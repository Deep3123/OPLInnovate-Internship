package com.hotel.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.management.pojo.Hotel;
import com.hotel.management.serviceimpl.HotelServiceImplementation;

@RestController
public class HotelController {
	@Autowired
	private HotelServiceImplementation himpl;
	
	@GetMapping("/getAllHotelDetails")
	public List<Hotel> getAllHotelDetails() {
//		himpl = new HotelServiceImplementation();
		return himpl.getAllHotelDetails();
	}

	@GetMapping("/getHotelDetail/{id}")
	public Hotel getHoteldetailbyHotelId(@PathVariable(value = "id") Integer id) {
//		himpl = new HotelServiceImplementation();
		return himpl.getHoteldetailbyHotelId(id);
	}

	@GetMapping("/updateHotelDetailbyId/{id}/{new_rating}")
	public List<Hotel> updateHotelDetailbyId(@PathVariable(value = "id") Integer id,
			@PathVariable(value = "new_rating") Double new_rating) {
//		himpl = new HotelServiceImplementation();
		return himpl.updateHotelDetailbyId(id, new_rating);
	}

	@GetMapping("/deleteHotelDetailbyId/{id}")
	public List<Hotel> deleteHotelDetailbyId(@PathVariable(value = "id") Integer id) {
//		himpl = new HotelServiceImplementation();
		return himpl.deleteHotelDetailbyId(id);
	}
}
