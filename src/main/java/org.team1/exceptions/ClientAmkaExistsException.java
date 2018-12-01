package org.team1.exceptions;

import com.sun.org.apache.xpath.internal.operations.String;

public class ClientAmkaExistsException extends Exception{

    public ClientAmkaExistsException(long amka) { super("Could not register with this amka " + amka); }

}
