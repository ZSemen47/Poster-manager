package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {

    MovieRepository repository = new MovieRepository();

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
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void findFilmById(){
        int id = 1;
        Movie[] actual = repository.findById(id);
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void removeAllFilms(){
        Movie[] actual = repository.removeAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void removeByValidId(){
        int id = 1;
        Movie[] actual = repository.removeById(id);
        Movie[] expected = new Movie[]{second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }
}