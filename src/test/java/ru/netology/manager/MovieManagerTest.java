package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    MovieManager manager = new MovieManager(3);
    Movie first = new Movie(1, 1, "first", 100, 1);
    Movie second = new Movie(2, 2, "second", 100, 1);
    Movie third = new Movie(3, 3, "third", 100, 1);
    Movie fourth = new Movie(4, 4, "fourth", 100, 1);
    Movie fifth = new Movie(5, 5, "five", 100, 1);
    Movie sixth = new Movie(6, 6, "six", 100, 1);
    Movie seventh = new Movie(7, 7, "seven", 100, 1);
    Movie eighth = new Movie(8, 8, "eight", 100, 1);
    Movie ninth = new Movie(9, 9, "nine", 100, 1);
    Movie tenth = new Movie(10, 10, "ten", 100, 1);
    Movie eleventh = new Movie(11, 11, "eleven", 100, 1);

    @BeforeEach
    @Test
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
        manager.add(tenth);
    }

    @Test
    public void checkFilms() {
        Movie[] expected = manager.findAll();
        Movie[] actual = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastAddedFilms() {
        manager.add(eleventh);
        Movie[] actual = manager.getLastAdded();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth};
        assertArrayEquals(expected, actual);
    }
}