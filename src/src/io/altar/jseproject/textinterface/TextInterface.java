package io.altar.jseproject.textinterface;

import java.util.ArrayList;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.test.Test;
import io.altar.jseproject.utils.Utils;


public class TextInterface {
	
	public static void mainMenu(){
		
    	System.out.println("1.List Products");
    	System.out.println("2.List Shelves");
    	System.out.println("3.Exit");
    	
    	int option = Utils.numValidate(1, 3);
    	
    	switch (option){
    	case 1:
    		productList();
    		break;
    	case 2:
    		ShelvesList();
    		break;
    	case 3:
    		System.out.println("I'm out!");
    	}
	}

	
	public static void productList(){
		
		System.out.println("1. Create new products");
		System.out.println("2. Edit existing products");
		System.out.println("3. Product details");
		System.out.println("4. Remove products");
		System.out.println("5. Return to previous menu");
		
		int option = Utils.numValidate(1, 5);
		
    	switch (option){
    	case 1:
    		productCase1();
    		productList();
    		break;
    	case 2:
    		break;
    	case 3:
    		break;
    	case 4:
    		break;
    	case 5:
    		TextInterface.mainMenu();
    	}
	}
	
	public static void ShelvesList(){
		
		System.out.println("1. Create new shelves");
		System.out.println("2. Edit existing shelves");
		System.out.println("3. Shelves details");
		System.out.println("4. Remove shelves");
		System.out.println("5. Return to previous menu");
		
		int option = Utils.numValidate(1, 5);
    	switch (option){
    	case 1:
    		break;
    	case 2:
    		break;
    	case 3:
    		break;
    	case 4:
    		break;
    	case 5:
    		TextInterface.mainMenu();
    	}
	}
	
	private static int pId=0;
	
	public static ArrayList<Product> pList = new ArrayList<Product>();
	
	public static void productCase1(){
		double x;
		double y;
		int z;
		
		if (!pList.isEmpty()){
		System.out.println("Products List\n");
		System.out.println(pList+"\n");
		}
		System.out.println("Enter the Product's price (€): ");
		x = priceVal(0.01);	
		System.out.println("Enter the Product's discount (€): ");
		y = discountVal(0, x);
		System.out.println("Enter the Product's IVA (%): ");
		z = Utils.chooseIVA();

		double yx= y*100/x;
		double roundOff2 = Math.round(yx*100.0)/100.0;
		System.out.println("\nYour newly added product has " + roundOff2 + "% discount. \n");
		Product p = new Product(pId, x, y, z);
		pId++;
		System.out.println("\nProduct successfully created. Returning to previous menu..\n");
	}
			// Validações do Produto
	
	public static int priceVal(double zero) {
		
		while (true) {
			if (Test.scanner.hasNextInt()) {
				int option = Test.scanner.nextInt();
				if (option >= zero) {
					return option;
				} else {
					System.out.println("Please input a valid number (higher than zero).");

				}
			} else {
				System.out.println("Error, NaN. Input a number.");
				Test.scanner.next();
			}
		}
	}
	
		// 			ValidaÃ§Ã£o do desconto
	public static double discountVal(int min, double max){
				
		while (true) {
			if (Test.scanner.hasNextInt()) {
				int option = Test.scanner.nextInt();
				if (option >= min && option <= max) {
					return option;
				} else {
					System.out.println("Please input a number between " + min + " and the product's total price (" + max + "€)");
				}
			} else {
				System.out.println("Error, NaN. Input a number.");
				Test.scanner.next();
			}
		}
		
	}
}
