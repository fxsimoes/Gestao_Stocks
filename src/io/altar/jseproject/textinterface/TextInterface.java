package io.altar.jseproject.textinterface;

import java.util.Map;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
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
			ShelvesList();
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

	public static void ShelvesList() {

		System.out.println("1. Create new shelves");
		System.out.println("2. Edit existing shelves");
		System.out.println("3. Shelves details");
		System.out.println("4. Remove shelves");
		System.out.println("5. Return to previous menu");

		int option = Utils.Validate(1, 5);
		switch (option) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			mainMenu();
		}
	}

	// Create a Product
	public static void productCreate() {

		if (!productList.isEmpty()) {

			System.out.println("Products List\n");
			for (Integer id : productList.keySet()) {
				System.out.println(productList.get(id));
			}
			System.out.println("\n");
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
		for (Integer id : productList.keySet()) {
			System.out.println(productList.get(id));
		}
		System.out.println("\n");
	}

	// Edit Product Details
	public static void productEdit() {

		// Inputs
		if (!productList.isEmpty()) {

			for (Integer id : productList.keySet()) {
				System.out.println(productList.get(id));
			}
			System.out.println("\n");

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
					"The products current price is " + currentPrice + "€. Enter the Product's new price (€): ");
			String price = Utils.validateEmpty(0, 50);

			if (price == null) {
				priceFixed = currentPrice;
			} else {
				priceFixed = Double.parseDouble(price);
			}

			System.out.println("The products current discount is " + currentDiscount
					+ "€. Enter the Product's new discount (€): ");
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
			ProductRepository.alterElement(id, null, discountFixed, ivaFixed, priceFixed);

			// Success messages
			System.out.println("\nThe product with ID of " + id + " has been successfully edited. ");
			System.out.println("Its new PVP, Discount and IVA are " + priceFixed + "€, " + discountFixed + "€, "
					+ ivaFixed + "% respectively.");
			System.out.println("\n");
		} else {
			System.out.println("You have no products to edit. Returning to main menu.");
		}

		// for(Integer id:pList.keySet()){
		// System.out.println(pList.get(id));
		// }
		// System.out.println("\n");
	}

	// Show Product Details
	public static void productDetails() {

		// Inputs
		if (!productList.isEmpty()) {
			for (Integer id : productList.keySet()) {
				System.out.println(productList.get(id));
			}
			System.out.println("\n");
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
				System.out.println("List of products:\n"+productList.get(id));
			}

			System.out.println("\n");

			System.out.println("Enter the ID of the product you want to remove (0 to return to previous menu):\n");
			Integer id = Utils.Validate(0, pId);

			if (id == 0) {
				productMenu();
			}

			System.out.println("Are you sure you want to remove the product " + id + "? (Y/N):");
			String str = Utils.validateStr();

			if (str.equals("Y")) {
				productList.removeElement(id);
				System.out.println("Product was successfully removed.");
			} else if (str.equals("N")) {
				System.out.println("Product wasn't removed.\n");
			}
		} else {
			System.out.println("You have no products to remove. Please insert some before.");
		}
	}
}
