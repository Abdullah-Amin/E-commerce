package com.abdullah.e_commerce.model.reponses;

import com.abdullah.e_commerce.model.data_classes.Product;

import java.util.List;

public class SearchResponse {

    public boolean status;
    public String message;
    List<Product> products;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", products=" + products +
                '}';
    }
}
