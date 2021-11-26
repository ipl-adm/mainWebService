package com.indieplay.mainWebService.handler;

import com.indieplay.mainWebService.exception.IPException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {IPException.class})
    protected String handleIPException(IPException ex, WebRequest request, Map<String, Object> model) {
        //updatable as ur wish
        return "error";
    }
}
