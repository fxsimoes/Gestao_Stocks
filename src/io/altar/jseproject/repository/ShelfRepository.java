package io.altar.jseproject.repository;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repository.EntityRepository;

public class ShelfRepository extends EntityRepository<Shelf> {
	private static final ShelfRepository INSTANCE = new ShelfRepository();

	private ShelfRepository() {}

	public static ShelfRepository getInstance() {
		return INSTANCE;
	}

	public static void editElement(Integer id, Double location, Integer capacity, Double dailyPrice) {
		((Shelf)ShelfRepository.getInstance().get(id)).setLocation(location);
		((Shelf)ShelfRepository.getInstance().get(id)).setCapacity(capacity);
		((Shelf)ShelfRepository.getInstance().get(id)).setDailyPrice(dailyPrice);
	}
}
