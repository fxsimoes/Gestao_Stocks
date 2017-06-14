package io.altar.jseproject.utils;

import java.util.Collections;
import java.util.Scanner;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.repository.EntityRepository;
import io.altar.jseproject.repository.ProductRepository;
import io.altar.jseproject.test.Test;

public class Utils {

	//		Validação de um intervalo
	public static int Validate(int min, int max) {
		
		while (true) {
			if (Test.scanner.hasNextInt()) {
				Integer option = Test.scanner.nextInt();
				if (option >= min && option <= max) {
					return option;
				} else if (min != max) {
					System.out.println("Please input a number between " + min + " and " + max);
				} else if (max < min) {
					System.out.println("Your database is empty. Please add some entities before contuining.");

				} else {
					System.out.println("Please input " + min + ", as it is the only option you currently have: ");
				}
			} else {
				System.out.println("Error, NaN. Input a number.");
				Test.scanner.next();
			}
		}
	}
	
	// Validações do Preço
	public static int Validate(double zero) {
		
		while (true) {
			if (Test.scanner.hasNextInt()) {
				int option = Test.scanner.nextInt();
				if (option >= zero) {
					return option;
				} else {
					System.out.println("Please input a valid number (higher than zero):");
				}
			} else {
				System.out.println("Error, NaN. Input a number.");
				Test.scanner.next();
			}
		}
	}

		// 			Validação do desconto
	public static double Validate(Integer min, double max){
				
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
		
		Test.scanner = new Scanner(System.in);
		
		while(true){
			if(Test.scanner.hasNext("Y") || Test.scanner.hasNext("N") ){	
				return Test.scanner.nextLine();
			}
			else {
				System.out.println("Please insert a valid option (Y/N): ");
				Test.scanner.next();
			}
		}		
	}
	
	public static String validateEmpty(int min, double max){

		Test.scanner = new Scanner(System.in);		
	
		while(true){
			String str = Test.scanner.nextLine();
			
			if(str.isEmpty()){
				return null;
			}else if(str.matches("-?\\d+(\\.\\d+)?")){
				Double option = Double.parseDouble(str);
				if(option >=min && option <= max){
					return str;
				}else{
					System.out.println("Please input a value between "+min+" and "+max+"€:");
				}
			}else{
				System.out.println("Error, please input a number: ");
			}
		}
}
	public static String validateEmpty(){
		Test.scanner = new Scanner(System.in);
		
		while(true) {
			String str = Test.scanner.nextLine();
			
			if(!str.isEmpty()){				
			
			switch (str){
				case "0": 
				case "6":	
				case "13":
				case "23": 
					return str;		
				default:
					System.out.println("Input a correct IVA value (0, 6, 13 or 23%): ");
					continue;		
			}
			}else{
				return null;
				}
		}
	}
	
}