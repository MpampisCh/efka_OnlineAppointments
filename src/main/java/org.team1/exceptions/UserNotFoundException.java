package org.team1.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("Could not find user");
    }
}
