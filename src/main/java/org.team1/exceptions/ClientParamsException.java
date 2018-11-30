package org.team1.exceptions;

public class ClientParamsException extends Exception{
    public ClientParamsException() {
        super("Could not register. Multiple parameters are wrong.");
    }

}
