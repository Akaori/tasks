package br.com.adatask.repository;

import br.com.adatask.domain.BaseTask;

import java.util.ArrayList;
import java.util.List;

public class ListRepository<T extends BaseTask, U> implements Repository<T, U> {
    private final List<T> tasks;

    public ListRepository() {
        tasks = new ArrayList<>();
    }

    @Override
    public void add(T task) {
        tasks.add(task);
    }

    @Override
    public void remove(T task) {
        tasks.remove(task);
    }

    @Override
    public void update(T task) {
        int index = tasks.indexOf(task);
        if (index != -1) {
            tasks.set(index, task);
        }
    }

    @Override
    public T findById(U id) {
        for (T task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    @Override
    public T find(String title) {
        for (T task : tasks) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }

    @Override
    public List<T> listAll() {
        return tasks;
    }

    @Override
    public List<T> filterBy(Class<?> type) {
        List<T> filtered = new ArrayList<>();
        for (T task : tasks) {
            if (task.getClass().equals(type)) {
                filtered.add(task);
            }
        }
        return filtered;
    }
}
