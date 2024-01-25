package br.com.adatask.service;

import br.com.adatask.domain.BaseTask;

import java.util.List;

public interface Service {
    void createPersonalTask(String title, String description, String deadline, String priority);

    void createWorkTask(String title, String description, String deadline, String category);

    void createStudyTask(String title, String description, String deadline, String status);

    BaseTask filterTaskByTitle(String title);

    BaseTask filterTaskById(Long id);

    void editTask(String title, String newTitle, String newDescription, String newDeadline);

    void removeTask(String title);

    List<BaseTask> listAllTasks();

    List<BaseTask> filterByType(Class<? extends BaseTask> type);
}

