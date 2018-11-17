package org.team1.exceptions;

public class NoLoggedInClientException extends RuntimeException {
    public NoLoggedInClientException() {
        super("There is no client logged in");
    }
}
