package com.abdullah.e_commerce.model.requests;

import com.google.gson.annotations.SerializedName;

public class AddToCartRequest {

    @SerializedName("product_id")
    private int addedToCartProductId;

    @SerializedName("color")
    private String color;

    @SerializedName("size")
    private String size;

    public AddToCartRequest(int addedToCartProductId, String color, String size) {
        this.addedToCartProductId = addedToCartProductId;
        this.color = color;
        this.size = size;
    }

    public int getAddedToCartProductId() {
        return addedToCartProductId;
    }

    public void setAddedToCartProductId(int addedToCartProductId) {
        this.addedToCartProductId = addedToCartProductId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "AddToCartRequest{" +
                "addedToCartProductId=" + addedToCartProductId +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
