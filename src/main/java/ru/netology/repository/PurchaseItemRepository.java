package ru.netology.repository;

import ru.netology.domain.PurchaseItem;

public class PurchaseItemRepository {
    private PurchaseItem[] items = new PurchaseItem[0];

    public PurchaseItemRepository() {
        this.items = items;
    }

    public void save(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] findAll() {
        return items;
    }

    public PurchaseItem[] findById(int id) {
        PurchaseItem[] tmp = new PurchaseItem[1];
        int index = 0;
        for (PurchaseItem item : items) {
            if (item.getId() == id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return items;
    }

    public PurchaseItem[] removeById(int id) {
        int length = items.length - 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        int index = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return items;
    }

    public PurchaseItem[] removeAll() {
        PurchaseItem[] empty = new PurchaseItem[0];
        items = empty;
        return items;
    }
}
