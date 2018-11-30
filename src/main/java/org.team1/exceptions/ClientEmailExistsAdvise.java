package org.team1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClientEmailExistsAdvise {

    @ResponseBody
    @ExceptionHandler(ClientEmailExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT) //409
    String clientEmailExistsExceptionHandler(ClientEmailExistsException e) {
        return e.getMessage();
    }
}
