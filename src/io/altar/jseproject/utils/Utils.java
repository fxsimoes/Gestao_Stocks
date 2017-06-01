package io.altar.jseproject.utils;

import java.util.ArrayList;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.test.Test;

public class Utils {

	//		Validação de um intervalo
	public static int numValidate(int min, double max) {
		
		int option = 0;
		
		while (true) {
			if (Test.scanner.hasNextInt()) {
				option = Test.scanner.nextInt();
				if (option >= min && option <= max) {
					return option;
				} else {
					System.out.println("Please input a number between " + min + " and " + max);

				}
			} else {
				System.out.println("Error, NaN. Input a number.");
				Test.scanner.next();
			}
		}
	}

	
	// 			Validação do IVA
	public static int ivaVal(int option){
		
			if (Test.scanner.hasNextInt()) {
			option = Test.scanner.nextInt();
			
			switch (option){
			case 0:				
				break;
			case 6:				
				break;
			case 13:				
				break;
			case 23:		
				break;
			default:
				System.out.println("Input correct IVA value (0, 6, 13 or 23): ");
			}
			} else {
			System.out.println("Error, NaN. Input a number.");
			Test.scanner.next();
		 	}
 	}
	
	
	
	// 		OLD	Validação do IVA
//	public static int ivaVal(int option){
//		
//		while (option != 0 && option != 6 && option !=13 && option !=23){
//			
//			System.out.println("Input correct IVA value (0, 6, 13 or 23): ");
//			if (Test.scanner.hasNextInt()) {
//				
//			option = Test.scanner.nextInt();
//			}
//		 else {
//			System.out.println("Error, NaN. Input a number.");
//			Test.scanner.next();
//		 	}
//		}
//		return option;
//	}
	
	
	
	// 			Validação do desconto
	public static double discountVal(double min, int max){
		
		int option = 0;
				
		while (true) {
			if (Test.scanner.hasNextInt()) {
				option = Test.scanner.nextInt();
				if (option >= min && option <= max) {
					return option;
				} else {
					System.out.println("Please input a number between" + min + " and the product's total price (" + max + ")");
				}
			} else {
				System.out.println("Error, NaN. Input a number.");
				Test.scanner.next();
			}
		}
		
	}
	
	public static int priceVal(double zero) {
		
		int option = 0;
		
		while (true) {
			if (Test.scanner.hasNextInt()) {
				option = Test.scanner.nextInt();
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
	
	public static ArrayList<Product> pList = new ArrayList<Product>();
	
	public static int pId=0;
	
	public static void productCase1(int option){
		double x;
		int y;
		double z;
		
		if (!pList.isEmpty()){
		System.out.println("Products List\n");
		System.out.println(pList+"\n");
		}
		System.out.println("Enter the Product's price (€): ");
		x = Utils.priceVal(0.01);
		System.out.println("Enter the Product's IVA (%): ");
		y = Utils.ivaVal(option);
		System.out.println("Enter the Product's discount (€): ");
		z = Utils.numValidate(0, x);
		double zx= z*100/x;
		double roundOff2 = Math.round(zx*100.0)/100.0;
		System.out.println("\nYour newly added product has " + roundOff2 + "% discount. \n");
		Product p = new Product(pId, x, y, z);
		pId++;
		System.out.println("\nProduct successfully created. Returning to previous menu..\n");
	}
	
}
