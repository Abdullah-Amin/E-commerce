package com.abdullah.e_commerce.model.reponses;


import com.abdullah.e_commerce.model.data_classes.User;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("status")
    public boolean status;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public User user;

    public LoginResponse(boolean status, String message, User user) {
        this.status = status;
        this.message = message;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", user=" + user +
                '}';
    }
}
