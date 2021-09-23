package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

public class ProductSizes {

    @SerializedName("name")
    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ProductSizes{" +
                "size='" + size + '\'' +
                '}';
    }
}
