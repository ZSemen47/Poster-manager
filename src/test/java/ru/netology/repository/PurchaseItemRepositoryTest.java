package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseItemRepositoryTest {

    PurchaseItemRepository repository = new PurchaseItemRepository();

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

    @BeforeEach
    public void setUp () {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
    }

    @Test
    public void findAllFilms() {
        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void findFilmById(){
        int id = 1;
        PurchaseItem[] actual = repository.findById(id);
        PurchaseItem[] expected = new PurchaseItem[]{first};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void removeAllFilms(){
        PurchaseItem[] actual = repository.removeAll();
        PurchaseItem[] expected = new PurchaseItem[]{};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void removeByValidId(){
        int id = 1;
        PurchaseItem[] actual = repository.removeById(id);
        PurchaseItem[] expected = new PurchaseItem[]{second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }
}