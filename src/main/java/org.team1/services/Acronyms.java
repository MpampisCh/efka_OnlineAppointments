package org.team1.services;

public enum Acronyms {

    DOCTORACRONYM ("D"),
    CLIENTACRONYM ("C\t");

    private final String text;

    Acronyms(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
