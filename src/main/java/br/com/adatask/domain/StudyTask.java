package br.com.adatask.domain;

import br.com.adatask.domain.enums.Tag;

public class StudyTask extends BaseTask {


    public StudyTask(String title, String description, String deadline) {
        super(title, description, deadline);
        this.tag = Tag.STUDY;
    }

}
