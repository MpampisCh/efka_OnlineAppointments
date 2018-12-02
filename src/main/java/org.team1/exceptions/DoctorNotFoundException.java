package org.team1.exceptions;

public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException(String amka) {
        super("Could not find doctor with amka " + amka);
    }
}
