package com.abdullah.e_commerce.model.reponses;

import com.abdullah.e_commerce.model.data_classes.Products;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductsResponse {

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<Products> productsList;

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

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    @Override
    public String toString() {
        return "ProductsResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", productsList=" + productsList +
                '}';
    }
}
