package io.altar.jseproject.model;

import io.altar.jseproject.textinterface.TextInterface;

public class Product {
	
	public int product_id;
	
	public String Shelves;
	
	public float discount;
	
	public int iva;
	
	public float price;
	
	public Product(int DiscountValue, int ivaTax, int finalPrice){
		
		discount= DiscountValue;
		iva= ivaTax;
		price=finalPrice;
		
		TextInterface.pList.add(this);
	}
		
	
//	public Product(String Shelves){
//		this.Shelves = name;
//	}
//	
//	public String getName(){
//		return this.name;
//	}
//	

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getShelves() {
		return Shelves;
	}

	public void setShelves(String shelves) {
		Shelves = shelves;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
