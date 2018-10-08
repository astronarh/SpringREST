package ru.astronarh.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Products code cannot be null")
    @Size(min = 13, max = 13, message="Products code ID - 13 character string")
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
