package org.team1.exceptions;

public class NoLoggedInDoctorException extends RuntimeException {
    public NoLoggedInDoctorException() {
        super("There is no doctor logged in");
    }
}
