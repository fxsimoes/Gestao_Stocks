package io.altar.jseproject.utils;

import io.altar.jseproject.test.Test;

public class Utils {

	//		Validação de um intervalo
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
}
