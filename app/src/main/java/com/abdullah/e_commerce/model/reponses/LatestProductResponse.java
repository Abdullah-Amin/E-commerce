package com.abdullah.e_commerce.model.reponses;

import com.abdullah.e_commerce.model.data_classes.LatestProduct;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LatestProductResponse {

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<LatestProduct> latestProductList;

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

    public List<LatestProduct> getLatestProductList() {
        return latestProductList;
    }

    public void setLatestProductList(List<LatestProduct> latestProductList) {
        this.latestProductList = latestProductList;
    }

    @Override
    public String toString() {
        return "LatestProductResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", latestProductList=" + latestProductList +
                '}';
    }
}
