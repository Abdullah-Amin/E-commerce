package com.abdullah.e_commerce.model.responses;

import com.abdullah.e_commerce.model.data_classes.CheckoutUserData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CheckoutResponse {

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private CheckoutUserData checkoutUserData;

    @SerializedName("items")
    private List<Object> items;

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

    public CheckoutUserData getCheckoutUserData() {
        return checkoutUserData;
    }

    public void setCheckoutUserData(CheckoutUserData checkoutUserData) {
        this.checkoutUserData = checkoutUserData;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CheckoutResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", checkoutUserData=" + checkoutUserData +
                ", items=" + items +
                '}';
    }
}
