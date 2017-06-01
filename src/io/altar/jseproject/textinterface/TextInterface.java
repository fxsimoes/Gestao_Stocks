package io.altar.jseproject.textinterface;

import io.altar.jseproject.utils.Utils;


public class TextInterface {
	
	public static void mainMenu(){
		
    	System.out.println("1.List Products");
    	System.out.println("2.List Shelves");
    	System.out.println("3.Exit");
    	
    	int option = Utils.numValidate(1, 3);
    	
    	switch (option){
    	case 1:
    		TextInterface.ProductList();
    		break;
    	case 2:
    		TextInterface.ShelvesList();
    		break;
    	case 3:
    		System.out.println("I'm out!");
    	}
	}
	
	public static void ProductList(){
		
		System.out.println("1. Create new products");
		System.out.println("2. Edit existing products");
		System.out.println("3. Product details");
		System.out.println("4. Remove products");
		System.out.println("5. Return to previous menu");
		
		int option = Utils.numValidate(1, 5);
		
    	switch (option){
    	case 1:
    		Utils.productCase1(option);
    		ProductList();
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
}
