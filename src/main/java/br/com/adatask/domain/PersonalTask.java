package br.com.adatask.domain;

import lombok.Data;

@Data
public class PersonalTask extends BaseTask {
    private String priority;

    public PersonalTask(String title, String description, String deadline, String priority) {
        super(title, description, deadline);
        this.priority = priority;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Prioridade: " + priority + "\n";
    }
}
