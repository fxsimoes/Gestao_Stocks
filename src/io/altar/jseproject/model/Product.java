package io.altar.jseproject.model;

public class Product {
	
	public int product_id;
	
	public String Shelves;
	
	public Product(){}
	
//	public Product(String Shelves){
//		this.Shelves = name;
//	}
//	
//	public String getName(){
//		return this.name;
//	}
//	
	public float discount;
	
	public int iva;
	
	public float finalPrice;

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

	public float getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}
}
