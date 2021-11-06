package com.abdullah.e_commerce.model.responses;

import com.google.gson.annotations.SerializedName;

public class ResetPasswordResponse {

    @SerializedName("msg")
    private String confirmationMessage;

    public String getConfirmationMessage() {
        return confirmationMessage;
    }

    public void setConfirmationMessage(String confirmationMessage) {
        this.confirmationMessage = confirmationMessage;
    }

    @Override
    public String toString() {
        return "ResetPasswordResponse{" +
                "confirmationMessage='" + confirmationMessage + '\'' +
                '}';
    }
}
