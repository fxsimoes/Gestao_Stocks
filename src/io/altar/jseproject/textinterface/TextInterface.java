package io.altar.jseproject.textinterface;

import io.altar.jseproject.utils.Utils;

public class TextInterface {
	
	public static void menuPrincipal(){
    	System.out.println("1.Listar Produtos");
    	System.out.println("2.Listar Prateleiras");
    	System.out.println("3.Sair");
    	
    	int option = Utils.numValidate(1, 3);
    	
    	switch (option){
    	case 1:
    		System.out.println("Lista de Produtos");
    		break;
    	case 2:
    		System.out.println("Lista de Prateleiras");
    		break;
    	case 3:
    		System.out.println("I'm out!");
    	}
	}

}
