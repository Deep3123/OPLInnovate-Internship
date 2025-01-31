package com.hotel.management.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hotel.management.pojo.Hotel;

@Component
public class HotelServiceImplementation {
	private static List<Hotel> lh = new ArrayList<>();

	static {
		lh.add(new Hotel("Hotel Royal", 101, "John Doe", "123 Main St, City", "50 rooms", 4.5));
		lh.add(new Hotel("Oceanview Resort", 102, "Jane Smith", "456 Beach Ave, Seaside", "120 rooms", 4.8));
		lh.add(new Hotel("Mountain Retreat", 103, "Alex Turner", "789 Hilltop Rd, Highlands", "75 rooms", 4.6));
		lh.add(new Hotel("City Lights Inn", 104, "Sarah Lee", "321 Downtown Blvd, Metropolis", "100 rooms", 4.2));
		lh.add(new Hotel("Sunset Plaza", 105, "Michael Clark", "112 Sunset Dr, Shoreline", "80 rooms", 4.3));
		lh.add(new Hotel("Grand Palace Hotel", 106, "Rachel Green", "876 Royal Rd, City Center", "150 rooms", 4.9));
		lh.add(new Hotel("Lakeside Lodge", 107, "David Brown", "234 Lakeview Dr, Lakeside", "60 rooms", 4.4));
		lh.add(new Hotel("Golden Sands Resort", 108, "Emily White", "567 Ocean Blvd, Sand City", "90 rooms", 4.7));
		lh.add(new Hotel("Forest Glade Hotel", 109, "Oliver King", "890 Forest Rd, Greenwood", "70 rooms", 4.1));
		lh.add(new Hotel("Urban Heights", 110, "Sophia Martinez", "678 Park Ave, Downtown", "120 rooms", 4.5));
		lh.add(new Hotel("The Grand Suite", 111, "Daniel Lee", "123 Elite St, Uptown", "50 rooms", 4.8));
		lh.add(new Hotel("Vista Bay Hotel", 112, "Olivia Harris", "432 Bayview Rd, Marina Bay", "85 rooms", 4.3));
		lh.add(new Hotel("Palm Tree Hotel", 113, "Ethan Young", "567 Palm St, Beachside", "110 rooms", 4.2));
		lh.add(new Hotel("Skyline Retreat", 114, "Ava Thomas", "789 Skyline Dr, Mountain City", "40 rooms", 4.6));
		lh.add(new Hotel("Luxury Inn", 115, "William Wilson", "345 Luxury Blvd, Royal Park", "160 rooms", 5.0));
	}

	public List<Hotel> getAllHotelDetails() {
		return lh;
	}

	public Hotel getHoteldetailbyHotelId(Integer id) {
		return lh.stream().filter(p -> p.getNumber().equals(id)).findFirst().get();
	}

	public List<Hotel> updateHotelDetailbyId(Integer id, Double new_rating) {
		lh.stream().filter(p -> p.getNumber().equals(id)).forEach(p -> p.setRating(new_rating));
		return lh;
	}

	public List<Hotel> deleteHotelDetailbyId(Integer id) {
		Hotel hotel = lh.stream().filter(p -> p.getNumber().equals(id)).findFirst().get();
		lh.remove(hotel);
		return lh;
	}
}