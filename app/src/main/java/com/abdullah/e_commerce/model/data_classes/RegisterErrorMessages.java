package com.abdullah.e_commerce.model.data_classes;

public class RegisterErrorMessages {

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
