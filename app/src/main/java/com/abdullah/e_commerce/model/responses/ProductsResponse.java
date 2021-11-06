package com.abdullah.e_commerce.model.responses;

import com.abdullah.e_commerce.model.data_classes.ProductItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductsResponse {

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<ProductItem> productsList;

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

    public List<ProductItem> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<ProductItem> productsList) {
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
