package br.com.adatask.domain;

import br.com.adatask.domain.enums.Tag;
import jdk.jfr.Label;


@Label("Pessoal")
public class PersonalTask extends BaseTask {

    public PersonalTask(String title, String description, String deadline) {
        super(title, description, deadline);
        this.tag = Tag.PERSONAL;
    }

}
