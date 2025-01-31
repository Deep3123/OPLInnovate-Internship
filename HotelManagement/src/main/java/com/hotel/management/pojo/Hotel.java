package com.hotel.management.pojo;

public class Hotel {
	private String name;
	private Integer number;
	private String owner;
	private String address;
	private String capacity_room;
	private Double rating;

	public Hotel() {
		super();
	}

	public Hotel(String name, Integer number, String owner, String address, String capacity_room, Double rating) {
		super();
		this.name = name;
		this.number = number;
		this.owner = owner;
		this.address = address;
		this.capacity_room = capacity_room;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCapacity_room() {
		return capacity_room;
	}

	public void setCapacity_room(String capacity_room) {
		this.capacity_room = capacity_room;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", number=" + number + ", owner=" + owner + ", address=" + address
				+ ", capacity_room=" + capacity_room + ", rating=" + rating + "]";
	}
}