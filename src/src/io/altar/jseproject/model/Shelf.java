package io.altar.jseproject.model;

public class Shelf {
	public int id;
	public int postal_code;
	public int capacity;
//	public String Product = new String();
	public int dailyPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getDailyPrice() {
		return dailyPrice;
	}
	public void setDailyPrice(int dailyPrice) {
		this.dailyPrice = dailyPrice;
	}
	}
