package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.PurchaseItemRepository;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)

public class PurchaseItemManagerTest {

    @Mock
    private PurchaseItemRepository repository;

    @InjectMocks
    PurchaseItemManager manager;

    PurchaseItem first = new PurchaseItem(1, 1, "first", 100, 1);
    PurchaseItem second = new PurchaseItem(2, 2, "second", 100, 1);
    PurchaseItem third = new PurchaseItem(3, 3, "third", 100, 1);
    PurchaseItem fourth = new PurchaseItem(4, 4, "fourth", 100, 1);
    PurchaseItem fifth = new PurchaseItem(5, 5, "five", 100, 1);
    PurchaseItem sixth = new PurchaseItem(6, 6, "six", 100, 1);
    PurchaseItem seventh = new PurchaseItem(7, 7, "seven", 100, 1);
    PurchaseItem eighth = new PurchaseItem(8, 8, "eight", 100, 1);
    PurchaseItem ninth = new PurchaseItem(9, 9, "nine", 100, 1);
    PurchaseItem tenth = new PurchaseItem(10, 10, "ten", 100, 1);
    PurchaseItem eleventh = new PurchaseItem(10, 10, "ten", 100, 1);

    @BeforeEach
    public void addFilmToTape() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
    }

    @Test
    public void addLessThenTenFilms() {
        manager.getAll();
        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addTenFilms() {
        manager.add(tenth);
        manager.getAll();
        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addMoreThenTenFilms() {
        manager.add(tenth);
        manager.add(eleventh);
        manager.getAll();
        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addFiveFilmsToTape() {
        manager.setNumberOfMovies(5);
        manager.getAll();
        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{ninth, eighth, seventh, sixth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addZeroFilmsToTape() {
        manager.setNumberOfMovies(0);
        manager.getAll();
        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{};
        assertArrayEquals(expected, actual);
    }

}