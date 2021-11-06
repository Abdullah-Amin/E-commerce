package com.abdullah.e_commerce.model.data_classes;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class ProductColor {

    @SerializedName("colorid")
    private String colorId;

    public void setColorId(String colorId){
        this.colorId = colorId;
    }

    public String getColorId(){
        return colorId;
    }

    @NonNull
    @Override
    public String toString(){
        return
                "ColorItem{" +
                        "colorId = '" + colorId + '\'' +
                        "}";
    }
}
