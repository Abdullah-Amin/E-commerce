package com.abdullah.e_commerce.model.responses;

import com.abdullah.e_commerce.model.data_classes.LoggedUser;
import com.google.gson.annotations.SerializedName;

public class LogoutResponse {

    public boolean status;
    public String message;

    @SerializedName("data")
    LoggedUser data;

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

    public LoggedUser getData() {
        return data;
    }

    public void setData(LoggedUser data) {
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
