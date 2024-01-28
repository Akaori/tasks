package br.com.adatask.domain;

import br.com.adatask.domain.enums.Tag;

public class WorkTask extends BaseTask {

    public static String getClassName() {
        return "Trabalho";
    }

    public WorkTask(String title, String description, String deadline) {
        super(title, description, deadline);
        this.tag = Tag.WORK;
    }


}
