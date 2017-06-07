package io.altar.jseproject.model;

import io.altar.jseproject.repository.ShelfRepository;

public class Shelf extends Entity {


	public Integer capacity;
//	public String Product = new String();
	public Double dailyRentalPrice;
	
	private Integer location;

	private Integer productID;

	public Integer getId() {
		return productID;
	}
	public void setId(int id) {
		this.productID = id;
	}

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public Double getDailyRentalPrice() {
		return dailyRentalPrice;
	}
	public void setDailyRentalPrice(Double dailyRentalPrice) {
		this.dailyRentalPrice = dailyRentalPrice;
	}
	public Integer getLocation() {
		return location;
	}
	public void setLocation(Integer location) {
		this.location = location;
	}
	
	public Shelf(Integer location, Integer capacity, Integer productID, Double dailyRentalPrice){
		this.location = location;
		this.capacity = capacity;
		this.productID = productID;
		this.dailyRentalPrice = dailyRentalPrice;
		ShelfRepository.getInstance().addToList(this);
	}
		@Override
	public String toString(){
		return "| ID: " + getId() + "| Location: " + location + "| Capacity: " + capacity + "| Product ID: " + productID + "| Location Rental Price: " + dailyRentalPrice + "â‚¬|\n";
	}
	
	}
