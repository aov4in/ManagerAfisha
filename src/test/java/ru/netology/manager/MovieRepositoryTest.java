package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;

public class MovieRepositoryTest {

    private MovieRepository movieRepository = new MovieRepository();

    private PurchaseItem first = new PurchaseItem(1, 1, "url1", "name1", "genre1", 6);
    private PurchaseItem second = new PurchaseItem(5, 2, "url2", "name2", "genre2", 14);
    private PurchaseItem third = new PurchaseItem(7, 3, "url3", "name3", "genre3", 18);

    @BeforeEach
    public void setUp() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
    }

    @Test
    public void shouldAdd() {
        PurchaseItem[] actual = movieRepository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, second, third};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 5;
        movieRepository.removeById(idToRemove);
        PurchaseItem[] actual = movieRepository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfExists() {
        int findId = 5;
        PurchaseItem actual = movieRepository.findById(findId);
        PurchaseItem expected = second;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfNotExists() {
        int findId = 4;
        PurchaseItem actual = movieRepository.findById(findId);

        assertNull(actual);
    }

    @Test
    public void shouldRemoveAll() {
        movieRepository.removeAll();
        PurchaseItem[] actual = movieRepository.removeAll();
        PurchaseItem[] expected = new PurchaseItem[0];

        assertArrayEquals(expected, actual);
    }
}
