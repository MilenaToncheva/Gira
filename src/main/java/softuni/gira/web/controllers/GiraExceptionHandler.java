package softuni.gira.web.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import softuni.gira.exceptions.TaskIllegalArgumentException;


@ControllerAdvice
public class GiraExceptionHandler {
    @ExceptionHandler(TaskIllegalArgumentException.class)
    public ModelAndView handleTaskCreateExceptions(RuntimeException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", ex.getMessage());

        return modelAndView;
    }

}
