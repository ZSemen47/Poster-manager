package ru.netology.manager;

import ru.netology.domain.PurchaseItem;
import ru.netology.repository.PurchaseItemRepository;

public class PurchaseItemManager {

    private PurchaseItemRepository repository;
    private int numberOfMovies;

    public PurchaseItemManager() {
    }

    public PurchaseItemManager(PurchaseItemRepository repository) {
        this.repository = repository;
    }

    public PurchaseItemManager(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public void add(PurchaseItem item) {
        repository.save(item);
    }

    public PurchaseItem[] getAll() {
        PurchaseItem[] items = repository.findAll();
        PurchaseItem[] result = new PurchaseItem[Math.min(items.length, numberOfMovies)];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public PurchaseItem[] findById(int id) {
        return repository.findById(id);
    }

    public PurchaseItem[] removeById(int id) {
        return repository.removeById(id);
    }

    public PurchaseItem[] removeAll() {
        return repository.removeAll();
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }
}