package org.team1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClientAmkaExistsAdvise {

    @ResponseBody
    @ExceptionHandler(ClientAmkaExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT) //409
    String clientAmkaExistsExceptionHandler(ClientAmkaExistsException e) {
        return e.getMessage();
    }

}
