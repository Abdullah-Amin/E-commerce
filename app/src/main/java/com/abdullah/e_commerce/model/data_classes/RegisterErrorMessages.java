package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

public class RegisterErrorMessages {

    @SerializedName("data")
    public String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "RegisterErrorMessages{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
