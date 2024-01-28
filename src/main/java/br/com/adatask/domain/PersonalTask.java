package br.com.adatask.domain;

import br.com.adatask.domain.enums.Tag;


public class PersonalTask extends BaseTask {

    public String getName () {
        return "Tarefa de Estudo";
    }

    public PersonalTask(String title, String description, String deadline) {
        super(title, description, deadline);
        this.tag = Tag.PERSONAL;
    }

}
