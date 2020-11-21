package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {

    private Movie[] items = new Movie[0];
    private int numberOfMovies = 10;

    public MovieManager() {
    }

    public MovieManager(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }


    public void add(Movie item) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] getLastAdded() {
        Movie[] result = new Movie[Math.min(items.length, numberOfMovies)];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
