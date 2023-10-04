package ru.kpfu.itis.paramonov.practice.dao;

import java.util.List;

public interface Dao<T> {
    T get(int id);

    List<T> getAll();

    void save(T t);
}
