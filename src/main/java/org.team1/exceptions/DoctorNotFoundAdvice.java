package org.team1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DoctorNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NoLoggedInClientException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String noLoggedInDoctorHandler(NoLoggedInClientException e) {
        return e.getMessage();
    }
}
