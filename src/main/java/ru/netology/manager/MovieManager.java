package ru.netology.manager;

import ru.netology.domain.PurchaseItem;

public class MovieManager {
    private PurchaseItem[] items = new PurchaseItem[0];

    public MovieManager(int posterLength) {
        this.posterLength = posterLength;
    }

    public MovieManager() {}

    private int posterLength = 10;

    public void add(PurchaseItem item) {

        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] getAll() {
        int resultLength = Math.min(posterLength, items.length);
        PurchaseItem[] result = new PurchaseItem[resultLength];
        // результат в обратном порядке
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}
