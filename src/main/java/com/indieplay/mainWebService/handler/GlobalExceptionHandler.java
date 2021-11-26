package com.indieplay.mainWebService.handler;

import com.indieplay.mainWebService.exception.IPException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {IPException.class})
    protected ModelAndView handleIPException(IPException ex, WebRequest request, HttpServletResponse response) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex.getClass().isAnnotationPresent(ResponseStatus.class)) {
            status = ex.getClass().getAnnotation(ResponseStatus.class).value();
        }

        ModelAndView modelAndView = new ModelAndView("error");
        Map<String, Object> pageModel = modelAndView.getModelMap();
        pageModel.put("statusName", status.name());
        pageModel.put("statusValue", status.value());
        pageModel.put("request", request);
        pageModel.put("exception", ex);

        response.setStatus(status.value());

        return modelAndView;
    }
}
