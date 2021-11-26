package com.indieplay.mainWebService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyExistsException extends IPException {

    public AlreadyExistsException(Class<?> clazz) {
        super(AlreadyExistsException.class.getSimpleName() + " — " + clazz.getName());
    }
}
