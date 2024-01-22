package br.com.adatask.repository;

import java.util.List;

public interface Repository<T> {
    void add(T task);
    void remove(T task);
    void update(T task);
    T find(String title);
    List<T> listAll();
    List<T> filterBy(Class<?> type);
}
