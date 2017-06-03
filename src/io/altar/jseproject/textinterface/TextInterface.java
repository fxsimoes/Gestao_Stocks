package io.altar.jseproject.textinterface;


import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.test.Test;
import io.altar.jseproject.utils.Utils;


public class TextInterface {
	
	public static LinkedHashMap<Integer, Product> pList = new LinkedHashMap<Integer, Product>();
	Set<Entry<Integer, Product>> set = pList.entrySet();
	
	private static int pId=1;
	
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
    		productCreate();
    		productList();
    		break;
    	case 2:
    		productEdit();
    		break;
    	case 3:
    		productDetails();
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

	// 			Create a Product
	public static void productCreate(){

		if (!pList.isEmpty()){
		System.out.println("Products List\n");
		for(Integer id:pList.keySet()){
			System.out.println(pList.get(id));
		}
		System.out.println("\n");
		}
		
		//			Inputs
		System.out.println("Enter the Product's price (€): ");
		double x = priceVal(0.01);	
		System.out.println("Enter the Product's discount (€): ");
		double y = discountVal(0, x);
		System.out.println("Enter the Product's IVA (%): ");
		int z = ivaVal();

		// 		 Round number to 2 float places
		double yx= y*100/x;
		double roundOff2 = Math.round(yx*100.0)/100.0;
		
		// 		 Create product and show results
		System.out.println("\nYour newly added product has " + roundOff2 + "% discount. \n");
		Product p = new Product(pId, x, y, z);
		pId++;
		System.out.println("\nProduct successfully created. Returning to previous menu..\n");
		
		//			Show Products in different lines
		for(Integer id:pList.keySet()){
			System.out.println(pList.get(id));
		}
		System.out.println("\n");
	}
	
	//			Edit Product Details
	public static void productEdit(){

	//		Inputs
		System.out.println("Enter the ID of the product you want to edit: ");
		int w = Utils.numValidate(0, pId);	
		
		for (Entry<Integer, Product> entry : pList.entrySet()){
		   if (entry.getKey().equals(pId)){
		      System.out.println(entry.getValue());
		   }
		}
		
		System.out.println("Enter the Product's new price (€): ");
		double x = priceVal(0.01);	
		System.out.println("Enter the Product's new discount (€): ");
		double y = discountVal(0, x);
		System.out.println("Enter the Product's new IVA value (%): ");
		int z = ivaVal();

		//		Product overwrite
		Product p = new Product(w, x, y, z);
		pList.put(w,p);
		
		//		Success messages
		System.out.println("\nThe product with ID of "+ w +" has been successfully edited. ");
		System.out.println("Its new PVP, Discount and IVA are "+x+"€, "+y+"€, "+z+"% respectively.");
		System.out.println("\n");
		
		for(Integer id:pList.keySet()){
			System.out.println(pList.get(id));
		}
		System.out.println("\n");
	}
	
	// 		Show Product Details
	public static void productDetails(){
		
		//		Inputs
		System.out.println("Enter the ID of the product you want to evaluate: ");
		int w = Utils.numValidate(0, pId);	
		boolean blnExists = pList.containsKey(w);
		System.out.println(blnExists);
		for (Entry<Integer, Product> entry : pList.entrySet()){
		   if (entry.getKey().equals(pId) && blnExists == false){
		      System.out.println(entry.getValue());
		   }
		   else if (blnExists == false){
			   System.out.println("Please enter a valid ID: ");
		   }
		}
		System.out.println(pList.get(w));
		
	}
	
	// 			Validações do Produto
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
	
		// 			Validação do desconto
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
	
	// 			Validação do IVA
	public static int ivaVal(){
		
		while(true) {
			while (!Test.scanner.hasNextInt() ) {
				System.out.println("Por favor, escolha uma das opcões");
				Test.scanner.next();
			}
			int option = Test.scanner.nextInt();
			switch (option){
				case 0: 
				case 6:	
				case 13:
				case 23: 
					return option;		
				default:
					System.out.println("Input a correct IVA value (0, 6, 13 or 23%): ");
					continue;
				}
			
		}
	
	}
}
