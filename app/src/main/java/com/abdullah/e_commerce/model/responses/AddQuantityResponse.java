package com.abdullah.e_commerce.model.responses;

import com.abdullah.e_commerce.model.data_classes.AddQuantityDetails;
import com.google.gson.annotations.SerializedName;

public class AddQuantityResponse {

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private AddQuantityDetails addQuantityDetails;

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

    public AddQuantityDetails getAddQuantityDetails() {
        return addQuantityDetails;
    }

    public void setAddQuantityDetails(AddQuantityDetails addQuantityDetails) {
        this.addQuantityDetails = addQuantityDetails;
    }

    @Override
    public String toString() {
        return "AddQuantityResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", addQuantityDetails=" + addQuantityDetails +
                '}';
    }
}
