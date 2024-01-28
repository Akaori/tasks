package br.com.adatask.domain.enums;

public enum Tag {
    PERSONAL("Pessoal"),
    WORK("Trabalho"),
    STUDY("Estudo");

    private String description;

    Tag(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
