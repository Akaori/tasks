package br.com.adatask.domain;

import br.com.adatask.domain.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class PersonalTask extends BaseTask {
    private Priority priority;

    public PersonalTask(String title, String description, String deadline, Priority priority) {
        super(title, description, deadline);
        this.priority = priority;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Prioridade: " + priority + "\n";
    }
}
