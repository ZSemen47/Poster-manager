package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

public class MovieManager {

    private MovieRepository repository;
    private int numberOfMovies;

    public MovieManager() {
    }

    public MovieManager(MovieRepository repository, int numberOfMovies) {
        this.repository = repository;
        this.numberOfMovies = numberOfMovies;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public void add(Movie item) {
        repository.save(item);
    }

    public Movie[] getAll() {
        Movie[] items = repository.findAll();
        Movie[] result = new Movie[numberOfMovies];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public Movie[] findById(int id){return repository.findById(id);}

    public Movie[] removeById(int id){return repository.removeById(id);}

    public Movie[] removeAll(){return repository.removeAll();}
}