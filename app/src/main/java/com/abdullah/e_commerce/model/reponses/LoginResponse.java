package com.abdullah.e_commerce.model.reponses;


import com.abdullah.e_commerce.model.data_classes.LoggedUser;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("status")
    public boolean status;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public LoggedUser loggedUser;

    public LoginResponse(boolean status, String message, LoggedUser loggedUser) {
        this.status = status;
        this.message = message;
        this.loggedUser = loggedUser;
    }

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

    public LoggedUser getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", loggedUser=" + loggedUser +
                '}';
    }
}
