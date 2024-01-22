package br.com.adatask.domain;

import lombok.Data;

@Data
public class WorkTask extends BaseTask {
    private String category;

    public WorkTask(String title, String description, String deadline, String category) {
        super(title, description, deadline);
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Categoria: " + category + "\n";
    }
}
