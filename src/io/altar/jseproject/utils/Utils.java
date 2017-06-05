package io.altar.jseproject.utils;

import io.altar.jseproject.test.Test;
import io.altar.jseproject.textinterface.TextInterface;

public class Utils {

	//		Validação de um intervalo
	public static int Validate(int min, int max) {
		
		int option = 0;
		
		while (true) {
			if (Test.scanner.hasNextInt()) {
				option = Test.scanner.nextInt();
				if (option >= min && option <= max) {
					return option;
				} else if(min != max){
					System.out.println("Please input a number between " + min + " and " + max);
				}else{
					System.out.println("Please input " + min + ", as it is the only option you currently have: ");
				}
			} else {
				System.out.println("Error, NaN. Input a number.");
				Test.scanner.next();
			}
		}
	}
	// 			Validações do Produto
	public static int Validate(double zero) {
		
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
	public static double Validate(int min, double max){
				
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
	public static int Validate(){
		
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
	public static String validateStr(){
		
		while(true){
			if(Test.scanner.hasNext("Y")){	
				System.out.println("Product was successfully removed.");
				return "Y";
			}else if(Test.scanner.hasNext("N")){
				System.out.println("Product wasn't removed.");
				return "N";
			}else {
				System.out.println("Please insert a valid option (Y/N): ");
				Test.scanner.next();
			}
			
		}
		
	}
}
