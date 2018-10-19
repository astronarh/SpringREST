package ru.astronarh.model;

import java.util.HashMap;

public class Answer {
    private String body;
    private HashMap<String, String> errors;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public Answer(String body, HashMap<String, String> errors) {
        this.body = body;
        this.errors = errors;
    }

    public Answer() {
    }

    @Override
    public String toString() {
        return "Answer{" +
                "body='" + body + '\'' +
                ", errors=" + errors +
                '}';
    }
}
