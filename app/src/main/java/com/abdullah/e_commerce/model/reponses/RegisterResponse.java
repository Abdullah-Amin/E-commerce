package com.abdullah.e_commerce.model.reponses;

import com.abdullah.e_commerce.model.data_classes.RegisterErrorMessages;
import com.abdullah.e_commerce.model.data_classes.RegisteredUser;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegisterResponse {

    public boolean status;
    public String message;

    @SerializedName("data")
    List<RegisterErrorMessages> errorMessagesList;

    @SerializedName("data")
    RegisteredUser registeredUser;

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

    public List<RegisterErrorMessages> getErrorMessagesList() {
        return errorMessagesList;
    }

    public void setErrorMessagesList(List<RegisterErrorMessages> errorMessagesList) {
        this.errorMessagesList = errorMessagesList;
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }

    @Override
    public String toString() {
        return "RegisterResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", errorMessagesList=" + errorMessagesList +
                ", registeredUser=" + registeredUser +
                '}';
    }
}
