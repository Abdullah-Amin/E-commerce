package com.abdullah.e_commerce.model.data_classes;

import java.util.List;

public class RegisterErrorBody {
    private boolean status;
    private String message;
    private List<RegisterErrorMessages> data;

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

    public List<RegisterErrorMessages> getData() {
        return data;
    }

    public void setData(List<RegisterErrorMessages> data) {
        this.data = data;
    }
}
