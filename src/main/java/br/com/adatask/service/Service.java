package br.com.adatask.service;

import br.com.adatask.domain.BaseTask;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface Service {
    void createTask(Class<? extends BaseTask> taskClass, String title, String description, String deadline)  throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

    BaseTask filterTaskByTitle(String title);

    BaseTask filterTaskById(Long id);

    void editTask(String title, String newTitle, String newDescription, String newDeadline);

    void removeTask(String title);

    List<BaseTask> listAllTasks();

    List<BaseTask> filterByType(Class<? extends BaseTask> type);
}

