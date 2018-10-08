package ru.astronarh.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.astronarh.model.Data;

@org.springframework.web.bind.annotation.RestController
public class RestController implements WebMvcConfigurer {

    @RequestMapping(value = "/", headers = "Accept=application/json")
    private String data(@RequestBody @Validated Data data, BindingResult bindingResult) {
        System.out.println(bindingResult);
        System.out.println(data);
        StringBuilder errors = new StringBuilder();
        if (bindingResult.hasErrors()) {
            for (Object object : bindingResult.getAllErrors()) {
                errors.append(((FieldError) object).getField()).append(" : ").append(((FieldError) object).getDefaultMessage()).append("\n");
            }
            return errors.toString();
        }
        return "ok";
    }
}
