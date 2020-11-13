package ru.netology.manager;

import ru.netology.domain.PurchaseItem;
import ru.netology.repository.PurchaseItemRepository;

public class PurchaseItemManager {

    private PurchaseItemRepository repository;
    private int numberOfMovies = 10;

    public PurchaseItemManager(PurchaseItemRepository repository) {
        this.repository = repository;
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

    public void findById(int id) {
        repository.findById(id);
    }


    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }
}