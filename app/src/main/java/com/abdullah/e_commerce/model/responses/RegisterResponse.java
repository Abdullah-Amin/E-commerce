package com.abdullah.e_commerce.model.responses;

import com.abdullah.e_commerce.model.data_classes.RegisterErrorMessages;
import com.abdullah.e_commerce.model.data_classes.RegisteredUser;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegisterResponse {

    public boolean status;
    public String message;

//    List<ProductImage> data;

    @SerializedName("data")
    RegisteredUser registeredUser;

    List<RegisterErrorMessages> errorMessages;

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

//    public List<ProductImage> getData() {
//        return data;
//    }
//
//    public void setData(List<ProductImage> data) {
//        this.data = data;
//    }


    public List<RegisterErrorMessages> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<RegisterErrorMessages> errorMessages) {
        this.errorMessages = errorMessages;
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
//                ", errorMessagesList=" + data +
                ", registeredUser=" + registeredUser +
                '}';
    }
}
