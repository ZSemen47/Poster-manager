package ru.netology.repository;

import ru.netology.domain.Movie;

public class MovieRepository {
    private Movie[] items = new Movie[0];

    public MovieRepository() {
        this.items = items;
    }

    public void save(Movie item) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] findAll() {
        return items;
    }

    public Movie[] findById(int id) {
        Movie[] tmp = new Movie[1];
        int index = 0;
        for (Movie item : items) {
            if (item.getId() == id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return items;
    }

    public Movie[] removeById(int id) {
        int length = items.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return items;
    }

    public Movie[] removeAll() {
        Movie[] empty = new Movie[0];
        items = empty;
        return items;
    }
}
