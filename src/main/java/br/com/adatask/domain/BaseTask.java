package br.com.adatask.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseTask {
    private String title;
    private String description;
    private String deadline;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BaseTask other) {
            return this.title.equals(other.title);
        }
        return false;
    }
}
