package br.com.adatask.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseTask implements Identifiable<Long> {
    private static int count = 0;
    private Long id;
    private String title;
    private String description;
    private String deadline;

    public BaseTask(String title, String description, String deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.id = (long) ++count;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BaseTask other) {
            return this.title.equals(other.title);
        }
        return false;
    }
}
