package com.indieplay.mainWebService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends IPException {

    public NotFoundException(Class<?> clazz) {
        super(NotFoundException.class.getSimpleName() + " — " + clazz.getName());
    }
}

