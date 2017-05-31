package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.utils.Utils;

public class TextInterface {
	
	
	public static ArrayList<Product> pList = new ArrayList<Product>();
	
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
		
		// List Products
		
		System.out.println("1. Create new products");
		System.out.println("2. Edit existing products");
		System.out.println("3. Product details");
		System.out.println("4. Remove products");
		System.out.println("5. Return to previous menu");
		
		int option = Utils.numValidate(1, 5);
		int x;
		int y;
		int z;
		
    	switch (option){
    	case 1:
    		System.out.println("Enter the Product's discount: ");
    		x = Utils.numValidate(0, 100);
    		System.out.println("Enter the Product's IVA: ");
    		y = Utils.numValidate(0, 100);
    		System.out.println("Enter the Product's price: ");
    		z = Utils.numValidate(0, 5000);
    		Product p = new Product(x, y, z);
    		System.out.println(p);
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
