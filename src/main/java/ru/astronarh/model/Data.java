package ru.astronarh.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

public class Data {

    @NotNull(message = "Seller cannot be null")
    @Size(min = 9, max = 9, message="Seller ID - 9 character string")
    private String seller;

    @NotNull(message = "Customer cannot be null")
    @Size(min = 9, max = 9, message="Customer ID - 9 character string")
    private String customer;

    @NotNull(message="Products cannot be null")
    @Valid
    private List<Product> products;

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Data{" +
                "seller='" + seller + '\'' +
                ", customer='" + customer + '\'' +
                ", products=" + products +
                '}';
    }
}
