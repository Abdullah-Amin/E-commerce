package com.abdullah.e_commerce.model.reponses;

import com.abdullah.e_commerce.model.data_classes.User;
import com.google.gson.annotations.SerializedName;

public class LogoutResponse {

    public boolean status;
    public String message;

    @SerializedName("data")
    User data;

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

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LogoutResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
