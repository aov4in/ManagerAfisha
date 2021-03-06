package ru.netology.repository;

import ru.netology.domain.PurchaseItem;

public class MovieRepository {
    private PurchaseItem[] items = new PurchaseItem[0];

    public PurchaseItem[] findAll() {
        return items;
    }

    public void save(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public void removeById(int id) {
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
    }

    public PurchaseItem findById(int id) {
        for (PurchaseItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public PurchaseItem[] removeAll() {
        PurchaseItem[] items = new PurchaseItem[0];

        return items;
    }
}
