package org.team1.exceptions;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Integer amka) {
        super("Could not find client with amka " + amka);
    }


}
