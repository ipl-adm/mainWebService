package com.indieplay.mainWebService.handler;

import com.indieplay.mainWebService.exception.IPException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
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
    protected String handleIPException(IPException ex,
                                             WebRequest request,
                                             HttpServletResponse response,
                                             Model model) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex.getClass().isAnnotationPresent(ResponseStatus.class)) {
            status = ex.getClass().getAnnotation(ResponseStatus.class).value();
        }

        model.addAttribute("statusName", status.name());
        model.addAttribute("statusValue", status.value());
        model.addAttribute("request", request);
        model.addAttribute("exception", ex);

        response.setStatus(status.value());

        return "error";
    }
}
