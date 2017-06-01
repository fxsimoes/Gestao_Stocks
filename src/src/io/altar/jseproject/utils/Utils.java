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

	
	// 			Validação do IVA
	public static int ivaVal(){
		
			if (Test.scanner.hasNextInt()) {
			int option = Test.scanner.nextInt();
			
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
			return 0;
 	}
	
	public static int chooseIVA(){
			
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
// 		OLD	Validação do IVA
//public static int ivaVal(int option){
//	
//	while (option != 0 && option != 6 && option !=13 && option !=23){
//		
//		System.out.println("Input correct IVA value (0, 6, 13 or 23): ");
//		if (Test.scanner.hasNextInt()) {
//			
//		option = Test.scanner.nextInt();
//		}
//	 else {
//		System.out.println("Error, NaN. Input a number.");
//		Test.scanner.next();
//	 	}
//	}
//	return option;
//}