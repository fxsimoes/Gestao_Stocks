package io.altar.jseproject.textinterface;

import java.util.Map;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repository.EntityRepository;
import io.altar.jseproject.repository.ProductRepository;
import io.altar.jseproject.repository.ShelfRepository;
import io.altar.jseproject.test.Test;
import io.altar.jseproject.utils.Utils;

public class TextInterface {

	// public static LinkedHashMap<Integer, Product> pList = new
	// LinkedHashMap<>();

	private static ProductRepository productList = ProductRepository.getInstance();
	private static ShelfRepository shelfList = ShelfRepository.getInstance();

	private static int pId = 0;
	private static int sId = 0;

	public static void mainMenu() {

		System.out.println("1.List Products");
		System.out.println("2.List Shelves");
		System.out.println("3.Exit");

		Integer option = Utils.Validate(1, 3);

		switch (option) {
		case 1:
			productMenu();
			break;
		case 2:
			shelfMenu();
			break;
		case 3:
			System.out.println("I'm out!");
		}
	}

	public static void productMenu() {

		System.out.println("1. Create new products");
		System.out.println("2. Edit existing products");
		System.out.println("3. Product details");
		System.out.println("4. Remove products");
		System.out.println("5. Return to previous menu");

		int option = Utils.Validate(1, 5);

		switch (option) {
		case 1:
			productCreate();
			productMenu();
			break;
		case 2:
			productEdit();
			productMenu();
			break;
		case 3:
			productDetails();
			productMenu();
			break;
		case 4:
			productRemove();
			productMenu();
			break;
		case 5:
			mainMenu();
		}
	}

	public static void shelfMenu() {

		System.out.println("1. Create new shelves");
		System.out.println("2. Edit existing shelves");
		System.out.println("3. Shelves details");
		System.out.println("4. Remove shelves");
		System.out.println("5. Return to previous menu");

		int option = Utils.Validate(1, 5);
		switch (option) {
		case 1:
			shelfCreate();
			shelfMenu();
			break;
		case 2:
			shelfEdit();
			shelfMenu();
			break;
		case 3:
			shelfDetails();
			shelfMenu();
			break;
		case 4:
			shelfRemove();
			shelfMenu();
			break;
		case 5:
			mainMenu();
		}
	}

	// Create a Product
	public static void productCreate() {

		if (!productList.isEmpty()) {

			productList.getList();
		}

		// Inputs
		System.out.println("Enter the Product's price (€): ");
		double price = Utils.Validate(0);
		System.out.println("Enter the Product's discount (€): ");
		double discount = Utils.Validate(0, price);
		System.out.println("Enter the Product's IVA (%): ");
		int iva = Utils.Validate();

		// Round number to 2 float places
		double discountedPrice = discount * 100 / price;
		double roundfloat2 = Math.round(discountedPrice * 100.0) / 100.0;

		// Create product and show results
		System.out.println("\nYour newly added product has " + roundfloat2 + "% discount. \n");
		pId++;
		Product p = new Product(pId, price, discount, iva);

		System.out.println("\nProduct successfully created. Returning to previous menu..\n");

		// Show Products in different lines
			productList.getList();
	}

	// Edit Product Details
	public static void productEdit() {

		// Inputs
		if (!productList.isEmpty()) {

			productList.getList();

			System.out.println("Enter the ID of the product you want to edit (0 to go back to main menu): ");

			Integer id = Utils.Validate(0, pId);

			if (id == 0) {
				productMenu();
			}

			double currentDiscount = ((Product) productList.get(id)).getDiscount();
			double currentPrice = ((Product) productList.get(id)).getPrice();
			int currentIva = ((Product) productList.get(id)).getIva();
			double priceFixed = 0;
			double discountFixed = 0;
			int ivaFixed = 0;

			System.out.println(
					"The products current price is " + currentPrice + "â‚¬. Enter the Product's new price (â‚¬): ");
			String price = Utils.validateEmpty(0);

			if (price == null) {
				priceFixed = currentPrice;
			} else {
				priceFixed = Double.parseDouble(price);
			}

			System.out.println("The products current discount is " + currentDiscount
					+ "â‚¬. Enter the Product's new discount (â‚¬): ");
			String discount = Utils.validateEmpty(0, priceFixed);

			if (discount == null) {
				discountFixed = currentDiscount;
			} else {
				discountFixed = Double.parseDouble(discount);
			}

			System.out.println(
					"The products current IVA is " + currentIva + "%. Enter the Product's new IVA value (%): ");
			String iva = Utils.validateEmpty();

			if (iva == null) {
				ivaFixed = currentIva;
			} else {
				ivaFixed = Integer.parseInt(iva);
			}

			// Product Editing
			ProductRepository.editElement(id, null, discountFixed, ivaFixed, priceFixed);

			// Success messages
			System.out.println("\nThe product with ID of " + id + " has been successfully edited. ");
			System.out.println("Its new PVP, Discount and IVA are " + priceFixed + "â‚¬, " + discountFixed + "â‚¬, "
					+ ivaFixed + "% respectively.");
			System.out.println("\n");
		} else {
			System.out.println("You have no products to edit. Returning to main menu.");
		}
	}

	// Show Product Details
	public static void productDetails() {

		// Inputs
		if (!productList.isEmpty()) {
			
			productList.getList();
			
			System.out.println(
					"Enter the ID of the product you want to evaluate (0 if you want to go back to main menu): ");
			int id = Utils.Validate(0, pId);

			if (id == 0) {
				productMenu();
			}
			productList.displayElement(pId);
		} else {
			System.out.println("You have no products to check details from. Please insert some before.");
		}
	}

	public static void productRemove() {
		
		if (!productList.isEmpty()) {

			for (Integer id : productList.keySet()) {
				System.out.println(productList.get(id));
			}

			System.out.println("\n");
			
			productList.getList();


			System.out.println("Enter the ID of the product you want to remove (0 to return to previous menu):\n");
			Integer id = Utils.Validate(0, pId);

			if (id == 0) {
				productMenu();
			}

			System.out.println("Are you sure you want to remove the product " + id + "? (Y/N):");
			String str = Utils.validateStr();

			if (str.equals("Y")) {
				productList.remove(id);
				System.out.println("Product was successfully removed.");
			} else if (str.equals("N")) {
				System.out.println("Product wasn't removed.\n");
			}
		} else {
			System.out.println("You have no products to remove. Please insert some before.");
		}
	}
	
	public static void shelfCreate(){
		if (!shelfList.isEmpty()) {

			shelfList.getList();
		}

		// Inputs		
		System.out.println("Enter the Shelf's location (): ");
		double location = Utils.Validate(0);
		
		System.out.println("Enter the Shelf's capacity (): ");
		Integer capacity = Utils.Validate(0);

		System.out.println("Enter the Shelf's daily price (€): ");
		double dailyPrice = Utils.Validate(0);


		// Create shelf and show results
		System.out.println("\nYour newly added shelf is placed on " + location + ", has " + capacity + " slots for products and costs " + dailyPrice+ "daily. \n");
		sId++;
		Shelf s = new Shelf(sId ,location, capacity, dailyPrice);

		System.out.println("\nShelf successfully created. Returning to previous menu..\n");

		// Show shelves in different lines
			shelfList.getList();
	}
	
	public static void shelfEdit() {

		// Inputs
		if (!shelfList.isEmpty()) {

			shelfList.getList();

			System.out.println("Enter the ID of the shelf you want to edit (0 to go back to main menu): ");

			Integer id = Utils.Validate(0, sId);

			if (id == 0) {
				shelfMenu();
			}

			double currentLocation = ((Shelf) shelfList.get(id)).getLocation();
			int currentCapacity = ((Shelf) shelfList.get(id)).getCapacity();
			double currentPrice = ((Shelf) shelfList.get(id)).getDailyPrice();
			double locationFixed = 0;
			Integer capacityFixed = 0;
			double priceFixed = 0;

			System.out.println(
					"The shelf's current location is " + currentLocation + ". Enter the shelf's new location: ");
			String location = Utils.validateEmpty(0);

			if (location == null) {
				locationFixed = currentPrice;
			} else {
				locationFixed = Double.parseDouble(location);
			}

			System.out.println("The shelf's current capacity is " + currentCapacity + " products. Enter the shelf's new capacity: ");
			String capacity = Utils.validateEmpty(0);

			if (capacity == null) {
				capacityFixed = currentCapacity;
			} else {
				capacityFixed = Integer.parseInt(capacity);
			}

			System.out.println(
					"The shelf's current daily price is " + currentPrice + "€. Enter the shelf's new price (€): ");
			String dailyPrice = Utils.validateEmpty(0);

			if (dailyPrice == null) {
				priceFixed = currentPrice;
			} else {
				priceFixed = Integer.parseInt(dailyPrice);
			}

			// Product Editing
			ShelfRepository.editElement(id, locationFixed, capacityFixed, priceFixed);

			// Success messages
			System.out.println("\nThe shelf with ID of " + id + " has been successfully edited. ");
			System.out.println("Its new location, capacity and daily price are " + locationFixed + ", " + capacityFixed + ", "
					+ priceFixed + "€ respectively.");
			System.out.println("\n");
		} else {
			System.out.println("You have no shelves to edit. Returning to main menu.");
		}
	}
	
	public static void shelfDetails() {

		// Inputs
		if (!shelfList.isEmpty()) {
			
			shelfList.getList();
			
			System.out.println(
					"Enter the ID of the shelf you want to evaluate (0 if you want to go back to main menu): ");
			int id = Utils.Validate(0, sId);

			if (id == 0) {
				shelfMenu();
			}
			shelfList.displayElement(sId);
		} else {
			System.out.println("You have no shelves to check details from. Please insert some before.");
		}
	}
	
	public static void shelfRemove() {
		
		if (!shelfList.isEmpty()) {

			for (Integer id : shelfList.keySet()) {
				System.out.println(shelfList.get(id));
			}

			System.out.println("\n");
			
			shelfList.getList();


			System.out.println("Enter the ID of the shelf you want to remove (0 to return to previous menu):\n");
			Integer id = Utils.Validate(0, pId);

			if (id == 0) {
				shelfMenu();
			}

			System.out.println("Are you sure you want to remove the shelf with ID " + id + "? (Y/N):");
			String str = Utils.validateStr();

			if (str.equals("Y")) {
				shelfList.remove(id);
				System.out.println("Shelf was successfully removed.");
			} else if (str.equals("N")) {
				System.out.println("Shelf wasn't removed.\n");
			}
		} else {
			System.out.println("You have no shelves to remove. Please insert some before.");
		}
	}
	
}
