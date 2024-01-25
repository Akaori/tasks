package br.com.adatask.repository;

import java.util.List;

public interface Repository<T, U> {
    void add(T task);
    void remove(T task);
    void update(T task);
    T findById(U id);
    T find(String title);
    List<T> listAll();
    List<T> filterBy(Class<?> type);
}
