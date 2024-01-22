package br.com.adatask.domain;

import lombok.Data;

@Data
public class StudyTask extends BaseTask {
    private String status;

    public StudyTask(String title, String description, String deadline, String status) {
        super(title, description, deadline);
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Status: " + status + "\n";
    }
}
