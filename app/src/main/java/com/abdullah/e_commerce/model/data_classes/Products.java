package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

public class Products {

    @SerializedName("name")
    private String productName;

    @SerializedName("description")
    private String productDescription;

    @SerializedName("price")
    private String productPrice;

    @SerializedName("discount")
    private String productDiscount;

    @SerializedName("price_after_discount")
    private String productPriceAfterDiscount;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(String productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getProductPriceAfterDiscount() {
        return productPriceAfterDiscount;
    }

    public void setProductPriceAfterDiscount(String productPriceAfterDiscount) {
        this.productPriceAfterDiscount = productPriceAfterDiscount;
    }

    public int getIntegerProductPrice(){
        if(!productPrice.isEmpty() || !productPrice.equals("") || productPrice != null)
            return Integer.parseInt(productPrice);
        else return 0;
    }

    public int getIntegerProductDiscount(){
        if(!productDiscount.isEmpty() || !productDiscount.equals("") || productDiscount != null)
            return Integer.parseInt(productDiscount);
        else return 0;
    }

    public int getIntegerProductPriceAfterDiscount(){
        if(!productPriceAfterDiscount.isEmpty() || !productPriceAfterDiscount.equals("") || productPriceAfterDiscount != null)
            return getIntegerProductPrice() - getIntegerProductDiscount();
        else return 0;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productDiscount='" + productDiscount + '\'' +
                ", productPriceAfterDiscount='" + productPriceAfterDiscount + '\'' +
                '}';
    }
}
