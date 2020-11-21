package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    MovieManager manager = new MovieManager();
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
        Movie[] expected = manager.getLastAdded();
        Movie[] actual = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getWhenLessThanNumberOfMovies() {
        MovieManager manager = new MovieManager(4);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        Movie[] actual = manager.getLastAdded();
        Movie[] expected = new Movie[]{ninth, eighth, seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getWhenOneMovieAdded() {
        MovieManager manager = new MovieManager(10);
        manager.add(first);
        Movie[] actual = manager.getLastAdded();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getWhenMoreThanNumberOfMovies() {
        manager.add(eleventh);
        Movie[] actual = manager.getLastAdded();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }
}