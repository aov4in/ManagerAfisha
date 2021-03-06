package ru.netology.manager;

import ru.netology.domain.PurchaseItem;
import ru.netology.repository.MovieRepository;

public class MovieManager {
    private MovieRepository repository;
    private int posterLength = 10;

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public void add(PurchaseItem item) {
        repository.save(item);
    }

    public PurchaseItem[] getAll() {
        PurchaseItem[] items = repository.findAll();
        int resultLength = Math.min(posterLength, items.length);
        PurchaseItem[] result = new PurchaseItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }


}
