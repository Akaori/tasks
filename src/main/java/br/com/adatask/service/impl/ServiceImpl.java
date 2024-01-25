package br.com.adatask.service.impl;

import br.com.adatask.domain.BaseTask;
import br.com.adatask.domain.PersonalTask;
import br.com.adatask.domain.StudyTask;
import br.com.adatask.domain.WorkTask;
import br.com.adatask.repository.Repository;
import br.com.adatask.service.Service;

import java.util.List;

public class ServiceImpl implements Service {
    private final Repository<BaseTask, Long> repository;

    public ServiceImpl(Repository<BaseTask, Long> repository) {
        this.repository = repository;
    }

    public void createPersonalTask(String title, String description, String deadline, String priority) {
        PersonalTask task = new PersonalTask(title, description, deadline, priority);
        repository.add(task);
    }

    public void createWorkTask(String title, String description, String deadline, String category) {
        WorkTask task = new WorkTask(title, description, deadline, category);
        repository.add(task);
    }

    public void createStudyTask(String title, String description, String deadline, String status) {
        StudyTask task = new StudyTask(title, description, deadline, status);
        repository.add(task);
    }

    public BaseTask filterTaskByTitle(String title) {
        return repository.find(title);
    }

    public BaseTask filterTaskById(Long id) {
        return repository.findById(id);
    }

    public void editTask(String title, String newTitle, String newDescription, String newDeadline, String newPriority, String newCategory, String newStatus) {
        BaseTask task = repository.find(title);

        if (task != null) {
            task.setTitle(newTitle);
            task.setDescription(newDescription);
            task.setDeadline(newDeadline);

            if (task instanceof PersonalTask) {
                PersonalTask personalTask = (PersonalTask) task;
                personalTask.setPriority(newPriority);
            } else if (task instanceof WorkTask) {
                WorkTask workTask = (WorkTask) task;
                workTask.setCategory(newCategory);
            } else if (task instanceof StudyTask) {
                StudyTask studyTask = (StudyTask) task;
                studyTask.setStatus(newStatus);
            }

            repository.update(task);
        }
    }

    public void removeTask(String title) {
        BaseTask task = repository.find(title);
        if (task != null) {
            repository.remove(task);
        }
    }

    public List<BaseTask> listAllTasks() {
        return repository.listAll();
    }

    public List<BaseTask> filterByType(Class<? extends BaseTask> type) {
        return repository.filterBy(type);
    }

}
