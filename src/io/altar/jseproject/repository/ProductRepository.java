package io.altar.jseproject.repository;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repository.EntityRepository;

public class ProductRepository extends EntityRepository<Product> {
	private static final ProductRepository INSTANCE = new ProductRepository();

	private ProductRepository() {}

	public static ProductRepository getInstance() {
		return INSTANCE;
	}

	public static void alterElement(Integer id, Integer[] shelf, Double discount, Integer tax, Double price) {
		((Product)ProductRepository.getInstance().get(id)).setShelf_idLoc(shelf);
		((Product)ProductRepository.getInstance().get(id)).setDiscount(discount);
		((Product)ProductRepository.getInstance().get(id)).setIva(tax);
		((Product)ProductRepository.getInstance().get(id)).setPrice(price);
	}
}
