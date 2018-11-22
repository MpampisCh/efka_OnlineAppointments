package org.team1;

public enum Acronyms {

    DOCTORACRONYM ("D\t"),
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
