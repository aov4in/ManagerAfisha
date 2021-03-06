package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.doReturn;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)

public class MovieManagerTest {
    @Mock
    private MovieRepository MovieRepository;
    @InjectMocks
    private MovieManager MovieManager;
    private PurchaseItem first = new PurchaseItem(1, 1, "url1", "name1", "genre1", 6);
    private PurchaseItem second = new PurchaseItem(2, 2, "url2", "name2", "genre2", 14);
    private PurchaseItem third = new PurchaseItem(3, 3, "url3", "name3", "genre3", 18);
    private PurchaseItem forth = new PurchaseItem(4, 4, "url4", "name4", "genre1", 6);

    @BeforeEach
    public void setUp() {
        MovieManager.add(first);
        MovieManager.add(second);
        MovieManager.add(third);
    }

    @Test
    public void shouldAdd() {
        MovieManager.add(forth);

        PurchaseItem[] returned = new PurchaseItem[]{first, second, third, forth};
        doReturn(returned).when(MovieRepository).findAll();

        PurchaseItem[] expected = new PurchaseItem[]{first, second, third, forth};
        PurchaseItem[] actual = MovieRepository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetAll() {
        PurchaseItem[] returned = new PurchaseItem[]{first, second, third};
        doReturn(returned).when(MovieRepository).findAll();

        PurchaseItem[] expected = new PurchaseItem[]{third, second, first};
        PurchaseItem[] actual = MovieManager.getAll();
        assertArrayEquals(expected, actual);

    }
}
