package io.altar.jseproject.utils;

import java.util.Scanner;

public class Utils {

	public static int numValidate(int min, int max) {
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		
		while (true) {
			if (scanner.hasNextInt()) {
				option = scanner.nextInt();
				if (option >= min && option <= max) {
					return option;
				} else {
					System.out.println("Please input a number between " + min + " and " + max);

				}
			} else {
				System.out.println("Error, NaN. Input a number.");
				scanner.next();
			}
		}
		
	}
	
//	public static 
	
}
