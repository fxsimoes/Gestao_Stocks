package io.altar.jseproject.model;

import io.altar.jseproject.textinterface.TextInterface;


public class Product {

	public int product_id;
	
	public String Shelves;
	
	public double discount;
	
	public int iva;
	
	public double price;

	@Override
	public String toString(){
		return "ID  " + product_id + "  | PVP  " + price + "€  | Discount  " + discount + "€  | IVA  " + iva + "%";
	}
	
	public Product(int id, double finalPrice, double DiscountValue, int ivaTax){
		
		product_id=id;
		discount= DiscountValue;
		iva= ivaTax;
		price=finalPrice;
		
		TextInterface.pList.put(this.product_id, this);
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

	public double getDiscount() {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}