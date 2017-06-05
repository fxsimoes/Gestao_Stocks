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
	
	private static int pId=0;
	
	public static void mainMenu(){
		
    	System.out.println("1.List Products");
    	System.out.println("2.List Shelves");
    	System.out.println("3.Exit");
    	
    	int option = Utils.Validate(1, 3);
    	
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
		
		int option = Utils.Validate(1, 5);
		
    	switch (option){
    	case 1:
    		productCreate();
    		productList();
    		break;
    	case 2:
    		productEdit();
    		productList();
    		break;
    	case 3:
    		productDetails();
    		productList();
    		break;
    	case 4:
    		productRemove();
    		productList();
    		break;
    	case 5:
    		mainMenu();
    	}
	}
	
	public static void ShelvesList(){
		
		System.out.println("1. Create new shelves");
		System.out.println("2. Edit existing shelves");
		System.out.println("3. Shelves details");
		System.out.println("4. Remove shelves");
		System.out.println("5. Return to previous menu");
		
		int option = Utils.Validate(1, 5);
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
    		mainMenu();
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
		double price = Utils.Validate(0.01);	
		System.out.println("Enter the Product's discount (€): ");
		double discount = Utils.Validate(0, price);
		System.out.println("Enter the Product's IVA (%): ");
		int iva = Utils.Validate();

		// 		 Round number to 2 float places
		double discountedPrice= discount*100/price;
		double roundfloat2 = Math.round(discountedPrice*100.0)/100.0;
		
		// 		 Create product and show results
		System.out.println("\nYour newly added product has " + roundfloat2 + "% discount. \n");
		pId++;
		Product p = new Product(pId, price, discount, iva);
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
	if(pList.containsKey(1)){
		System.out.println("Enter the ID of the product you want to edit: ");
		int id = Utils.Validate(1, pId);	
		
		for (Entry<Integer, Product> entry : pList.entrySet()){
		   if (entry.getKey().equals(pId)){
		      System.out.println(entry.getValue());
					  }
		}
			System.out.println("The products current price is " + "€. Enter the Product's new price (€): ");
			double price = Utils.Validate(0.01);	
			System.out.println("Enter the Product's new discount (€): ");
			double discount = Utils.Validate(0, price);
			System.out.println("Enter the Product's new IVA value (%): ");
			int iva = Utils.Validate();

			//		Product overwrite
			Product p = new Product(id, price, discount, iva);
			pList.replace(id,p);
			
			//		Success messages
			System.out.println("\nThe product with ID of "+ id +" has been successfully edited. ");
			System.out.println("Its new PVP, Discount and IVA are "+price+"€, "+discount+"€, "+iva+"% respectively.");
			System.out.println("\n");		
		}
		else{
			System.out.println("You have no products to edit. Returning to main menu.");	
		}
		
		for(Integer id:pList.keySet()){
			System.out.println(pList.get(id));
		}
			System.out.println("\n");
	}

	// 		Show Product Details
	public static void productDetails(){
		
		//		Inputs
	if (pList.containsKey(1)){
		
		System.out.println("Enter the ID of the product you want to evaluate: ");
		int id = Utils.Validate(1, pId);
		
		for (Entry<Integer, Product> entry : pList.entrySet()){
			if (entry.getKey().equals(pId)){
				System.out.println(entry.getValue());
		  	}
		}
		}else{
			System.out.println("You have no products to check details from. Please insert some before.");
		}
	}
	
	public static void productRemove(){
		
		if (pList.containsKey(1)){
			
			System.out.println("Enter the ID of the product you want to evaluate: ");
			int id = Utils.Validate(1, pId);
			System.out.println("Are you sure you want to remove the product "+id+"? (Y/N):" );
			String str = Utils.validateStr();
			
			pList.remove(id);
			for (Entry<Integer, Product> entry : pList.entrySet()){
				if (entry.getKey().equals(pId)){
					System.out.println(entry.getValue());
			  	}
			}
			}else{
				System.out.println("You have no products to remove. Please insert some before.");
			}
	}
}
