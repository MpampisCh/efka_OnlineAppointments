package org.team1.exceptions;

public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException(Long amka) {
        super("Could not find doctor with amka " + amka);
    }
}
