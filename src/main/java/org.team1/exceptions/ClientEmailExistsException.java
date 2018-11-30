package org.team1.exceptions;

public class ClientEmailExistsException extends Exception {

    public ClientEmailExistsException(String email) {
        super("Could not register with this email " + email);
    }

}
