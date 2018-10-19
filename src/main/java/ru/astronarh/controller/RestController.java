package ru.astronarh.controller;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.astronarh.model.Answer;
import ru.astronarh.model.Data;

import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController implements WebMvcConfigurer {

    @RequestMapping(value = "/", headers = "Accept=application/json")
    private Answer data(@RequestBody @Validated Data data, BindingResult bindingResult) {
        Answer answer = new Answer();

        //StringBuilder errors = new StringBuilder();
        if (bindingResult.hasErrors()) {
            HashMap<String, String> errors = new HashMap<String, String>();

            for (Object object : bindingResult.getAllErrors()) {
                //errors.append(((FieldError) object).getField()).append(" : ").append(((FieldError) object).getDefaultMessage()).append("\n");
                errors.put(((FieldError) object).getField(), ((FieldError) object).getDefaultMessage());
            }

            return new Answer("Here some error!", errors);
        }
        return new Answer("Ok", null);
    }

    @ExceptionHandler(Exception.class)
    public Answer handleExceptions(HttpMessageNotReadableException anExc) {
        return new Answer("Here some error!", new HashMap<String, String>(){{put("Input data", "Wrong input data");}});
    }
}
