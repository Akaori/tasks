package br.com.adatask.domain;

import br.com.adatask.domain.enums.Tag;
import jdk.jfr.Label;


@Label("Trabalho")
public class WorkTask extends BaseTask {

    public WorkTask(String title, String description, String deadline) {
        super(title, description, deadline);
        this.tag = Tag.WORK;
    }


}
