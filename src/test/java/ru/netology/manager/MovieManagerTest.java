package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

public class MovieManagerTest {

    @Mock
    private MovieRepository repository;

    @InjectMocks
    MovieManager manager = new MovieManager(repository, 10);

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
    Movie eleventh = new Movie(10, 10, "ten", 100, 1);

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
        manager.setNumberOfMovies(9);
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(repository).findAll();
        manager.getAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addTenFilms() {
        manager.add(tenth);
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        manager.getAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addMoreThenTenFilms() {
        manager.add(tenth);
        manager.add(eleventh);
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();
        manager.getAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addFiveFilmsToTape() {
        manager.setNumberOfMovies(5);
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(repository).findAll();
        manager.getAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{ninth, eighth, seventh, sixth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addZeroFilmsToTape() {
        manager.setNumberOfMovies(0);
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(repository).findAll();
        manager.getAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }

    @Test void findAll() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void findById() {
        int id = 3;
        Movie[] returned = new Movie[]{third};
        doReturn(returned).when(repository).findById(id);
        Movie[] actual = manager.findById(id);
        Movie[] expected = new Movie[]{third};
        assertArrayEquals(expected, actual);
        verify(repository).findById(id);
    }
    @Test
    public void removeById() {
        int id = 9;
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth};
        doReturn(returned).when(repository).removeById(id);
        Movie[] actual = manager.removeById(id);
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth};
        assertArrayEquals(expected, actual);
        verify(repository).removeById(id);
    }

    @Test
    public void removeAll() {
        Movie[] returned = new Movie[]{};
        doReturn(returned).when(repository).removeAll();
        Movie[] actual = manager.removeAll();
        Movie[] expected = {};
        assertArrayEquals(actual, expected);
        verify(repository).removeAll();
    }
}