package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerAddFilmsTest {
    private MovieManager movieManager = new MovieManager();
    private PurchaseItem first = new PurchaseItem(1, 1, "url1", "name1", "genre1", 6);
    private PurchaseItem second = new PurchaseItem(2, 2, "url2", "name2", "genre2", 14);


    @Test
    public void shouldAddMovie() {
        movieManager.add(first);
        movieManager.add(second);


        PurchaseItem[] actual = movieManager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{second, first};

        assertArrayEquals(expected, actual);
    }
}
