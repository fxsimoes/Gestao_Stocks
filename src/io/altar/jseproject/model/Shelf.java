package io.altar.jseproject.model;

import io.altar.jseproject.repository.ShelfRepository;

public class Shelf extends Entity {
	public int productID;
	public Double location;
	public int capacity;
//	public String Product = new String();
	public Double dailyPrice;
	
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
	public Double getDailyPrice() {
		return dailyPrice;
	}
	public void setDailyPrice(Double price) {
		this.dailyPrice = price;
	}
	public Double getLocation() {
		return location;
	}
	public void setLocation(Double location) {
		this.location = location;
	}
	public Shelf(Double location, Integer capacity, Integer productID, Double dailyPrice){
		this.location = location;
		this.capacity = capacity;
		this.productID = productID;
		this.location = dailyPrice;
		ShelfRepository.getInstance().addToList(this);
	}
	
	@Override
	public String toString(){
		return "| ID: " + getId() + "| Location: " + location + "| Capacity: " + capacity + "| Product ID: " + productID + "| Location Rental Price: " + location + "â‚¬|\n";
	}

	}
