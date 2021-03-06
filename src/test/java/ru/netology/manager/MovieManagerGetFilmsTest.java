package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerGetFilmsTest {

    private MovieManager movieManager = new MovieManager();
    private PurchaseItem first = new PurchaseItem(1, 1, "url1", "name1", "genre1", 6);
    private PurchaseItem second = new PurchaseItem(2, 2, "url2", "name2", "genre2", 14);
    private PurchaseItem third = new PurchaseItem(3, 3, "url3", "name3", "genre3", 18);
    private PurchaseItem forth = new PurchaseItem(4, 4, "url4", "name4", "genre1", 6);
    private PurchaseItem fifth = new PurchaseItem(5, 5, "url5", "name5", "genre2", 14);
    private PurchaseItem sixth = new PurchaseItem(6, 6, "url6", "name6", "genre3", 18);
    private PurchaseItem seventh = new PurchaseItem(7, 7, "url7", "name7", "genre1", 6);
    private PurchaseItem eighth = new PurchaseItem(8, 8, "url8", "name8", "genre2", 14);
    private PurchaseItem ninth = new PurchaseItem(9, 9, "url9", "name9", "genre3", 18);
    private PurchaseItem tenth = new PurchaseItem(10, 10, "url10", "name10", "genre1", 6);
    private PurchaseItem eleventh = new PurchaseItem(11, 11, "url11", "name11", "genre2", 14);
    private PurchaseItem twelfth = new PurchaseItem(12, 12, "url12", "name12", "genre3", 18);
    private PurchaseItem thirteenth = new PurchaseItem(13, 13, "url13", "name13", "genre3", 18);

    @Test
    public void shouldGet10films() {
        movieManager.add(first);
        movieManager.add(second);
        movieManager.add(third);
        movieManager.add(forth);
        movieManager.add(fifth);
        movieManager.add(sixth);
        movieManager.add(seventh);
        movieManager.add(eighth);
        movieManager.add(ninth);
        movieManager.add(tenth);

        PurchaseItem[] actual = movieManager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGet5films() {
        MovieManager movieManager = new MovieManager(5);
        movieManager.add(first);
        movieManager.add(second);
        movieManager.add(third);
        movieManager.add(forth);
        movieManager.add(fifth);

        PurchaseItem[] actual = movieManager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{fifth, forth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGet10not13() {
        movieManager.add(first);
        movieManager.add(second);
        movieManager.add(third);
        movieManager.add(forth);
        movieManager.add(fifth);
        movieManager.add(sixth);
        movieManager.add(seventh);
        movieManager.add(eighth);
        movieManager.add(ninth);
        movieManager.add(tenth);
        movieManager.add(eleventh);
        movieManager.add(twelfth);
        movieManager.add(thirteenth);

        PurchaseItem[] actual = movieManager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{thirteenth, twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth};

        assertArrayEquals(expected, actual);
    }
}
