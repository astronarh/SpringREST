package ru.astronarh.controller;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.astronarh.model.Data;

@org.springframework.web.bind.annotation.RestController
public class RestController implements WebMvcConfigurer {

    @RequestMapping(value = "/", headers = "Accept=application/json")
    private String data(@RequestBody @Validated Data data, BindingResult bindingResult) {
        StringBuilder errors = new StringBuilder();
        if (bindingResult.hasErrors()) {
            for (Object object : bindingResult.getAllErrors()) {
                errors.append(((FieldError) object).getField()).append(" : ").append(((FieldError) object).getDefaultMessage()).append("\n");
            }
            return errors.toString();
        }
        return "ok";
    }

    @ExceptionHandler(Exception.class)
    public String handleExceptions(HttpMessageNotReadableException anExc) {
        return anExc.toString(); // do something better than this ;)
    }
}
