package com.abdullah.e_commerce.model.data_classes;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class LatestProduct {

    @SerializedName("name")
    private String latestProductName;

    @SerializedName("description")
    private String latestProductDescription;

    @SerializedName("price")
    private String latestProductPrice;

    @SerializedName("discount")
    private String latestProductDiscount;

    @SerializedName("price_after_discount")
    private String latestProductPriceAfterDiscount;

    @SerializedName("brand_id")
    private String latestProductBrandId;

    @SerializedName("category_id")
    private String latestProductCategoryId;

    @SerializedName("shop_id")
    private String latestProductShopId;

    @SerializedName("status")
    private String latestProductStatus;

    @SerializedName("created_at")
    private String latestProductCreatedAt;

    @SerializedName("updated_at")
    private String latestProductUpdatedAt;

    public String getLatestProductName() {
        return latestProductName;
    }

    public void setLatestProductName(String latestProductName) {
        this.latestProductName = latestProductName;
    }

    public String getLatestProductDescription() {
        return latestProductDescription;
    }

    public void setLatestProductDescription(String latestProductDescription) {
        this.latestProductDescription = latestProductDescription;
    }

    public String getLatestProductPrice() {
        return latestProductPrice;
    }

    public void setLatestProductPrice(String latestProductPrice) {
        this.latestProductPrice = latestProductPrice;
    }

    public String getLatestProductDiscount() {
        return latestProductDiscount;
    }

    public void setLatestProductDiscount(String latestProductDiscount) {
        this.latestProductDiscount = latestProductDiscount;
    }

    public String getLatestProductPriceAfterDiscount() {
        return latestProductPriceAfterDiscount;
    }

    public void setLatestProductPriceAfterDiscount(String latestProductPriceAfterDiscount) {
        this.latestProductPriceAfterDiscount = latestProductPriceAfterDiscount;
    }

    public String getLatestProductBrandId() {
        return latestProductBrandId;
    }

    public void setLatestProductBrandId(String latestProductBrandId) {
        this.latestProductBrandId = latestProductBrandId;
    }

    public String getLatestProductCategoryId() {
        return latestProductCategoryId;
    }

    public void setLatestProductCategoryId(String latestProductCategoryId) {
        this.latestProductCategoryId = latestProductCategoryId;
    }

    public String getLatestProductShopId() {
        return latestProductShopId;
    }

    public void setLatestProductShopId(String latestProductShopId) {
        this.latestProductShopId = latestProductShopId;
    }

    public String getLatestProductStatus() {
        return latestProductStatus;
    }

    public void setLatestProductStatus(String latestProductStatus) {
        this.latestProductStatus = latestProductStatus;
    }

    public String getLatestProductCreatedAt() {
        return latestProductCreatedAt;
    }

    public void setLatestProductCreatedAt(String latestProductCreatedAt) {
        this.latestProductCreatedAt = latestProductCreatedAt;
    }

    public String getLatestProductUpdatedAt() {
        return latestProductUpdatedAt;
    }

    public void setLatestProductUpdatedAt(String latestProductUpdatedAt) {
        this.latestProductUpdatedAt = latestProductUpdatedAt;
    }

    public int getIntegerLatestProductPrice(){
        return Integer.parseInt(latestProductPrice);
    }

    public int getIntegerLatestProductDiscount(){
        return Integer.parseInt(latestProductDiscount);
    }

    public int getIntegerProductPriceAfterDiscount(){
        return getIntegerLatestProductPrice() - getIntegerLatestProductDiscount();
    }

    @NonNull
    @Override
    public String toString() {
        return "LatestProduct{" +
                "latestProductName='" + latestProductName + '\'' +
                ", latestProductDescription='" + latestProductDescription + '\'' +
                ", latestProductPrice='" + latestProductPrice + '\'' +
                ", latestProductDiscount='" + latestProductDiscount + '\'' +
                ", latestProductPriceAfterDiscount='" + latestProductPriceAfterDiscount + '\'' +
                ", latestProductBrandId='" + latestProductBrandId + '\'' +
                ", latestProductCategoryId='" + latestProductCategoryId + '\'' +
                ", latestProductShopId='" + latestProductShopId + '\'' +
                ", latestProductStatus='" + latestProductStatus + '\'' +
                ", latestProductCreatedAt='" + latestProductCreatedAt + '\'' +
                ", latestProductUpdatedAt='" + latestProductUpdatedAt + '\'' +
                '}';
    }
}
