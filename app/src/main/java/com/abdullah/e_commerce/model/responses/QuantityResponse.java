package com.abdullah.e_commerce.model.responses;

import com.abdullah.e_commerce.model.data_classes.QuantityDetails;
import com.google.gson.annotations.SerializedName;

public class QuantityResponse {

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private QuantityDetails quantityDetails;

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

    public QuantityDetails getQuantityDetails() {
        return quantityDetails;
    }

    public void setQuantityDetails(QuantityDetails quantityDetails) {
        this.quantityDetails = quantityDetails;
    }

    @Override
    public String toString() {
        return "QuantityResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", quantityDetails=" + quantityDetails +
                '}';
    }
}
