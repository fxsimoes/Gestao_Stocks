package io.altar.jseproject.utils;

import java.util.stream.IntStream;

import io.altar.jseproject.utils.Test;

public class Utils {

	public static int numValidate(int min, int max) {
		
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

	public static int ivaVal(int choice){
		
			
		while (choice != 6 && choice != 12 && choice !=21 && choice !=23){
	
			if (Test.scanner.hasNextInt()) {
			choice = Test.scanner.nextInt();
			}
		
		 else {
			System.out.println("Error, NaN. Input a number.");
			Test.scanner.next();
		 	}
			System.out.println("Input correct IVA value (2, 6, 21 or 23): ");
		}
		return choice;
/*		if (Test.scanner.hasNextInt()) {
			if (choice == 2 || choice ==6 || choice == 21 || choice == 23) {
				
				System.out.println("Done");
				return choice;
			} else {
				
				Test.scanner.next();
			}
		} else {
			System.out.println("Error, NaN. Input a number.");
			Test.scanner.next();
		} */
	}
}
