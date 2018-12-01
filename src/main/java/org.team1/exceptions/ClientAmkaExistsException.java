package org.team1.exceptions;

public class ClientAmkaExistsException extends Exception{

    public ClientAmkaExistsException(String amka) { super("Could not register with this amka " + amka); }

}
