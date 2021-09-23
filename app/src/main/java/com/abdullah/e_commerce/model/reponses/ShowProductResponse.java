package com.abdullah.e_commerce.model.reponses;

import com.abdullah.e_commerce.model.data_classes.ShowedProductData;
import com.google.gson.annotations.SerializedName;

public class ShowProductResponse {

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private ShowedProductData showedProductData;

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

    public ShowedProductData getShowedProductData() {
        return showedProductData;
    }

    public void setShowedProductData(ShowedProductData showedProductData) {
        this.showedProductData = showedProductData;
    }

    @Override
    public String toString() {
        return "ShowProductResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", showedProductData=" + showedProductData +
                '}';
    }
}
