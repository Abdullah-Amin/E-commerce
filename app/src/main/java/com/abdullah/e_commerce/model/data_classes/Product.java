package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

public class Product {

    public int id;
    public String name;
    public String description;
    public String price;
    public String discount;

    @SerializedName("price_after_discount")
    public String priceAfterDiscount;

    @SerializedName("brand_id")
    public String brandId;

    @SerializedName("category_id")
    public String categoryId;

    @SerializedName("shop_id")
    public String shopId;

    public String status;

    @SerializedName("created_at")
    public String createdAt;

    @SerializedName("updated_at")
    public String updatedAt;

    public Product(int id, String name, String description, String price, String discount, String priceAfterDiscount, String brandId, String categoryId, String shopId, String status, String createdAt, String updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.priceAfterDiscount = priceAfterDiscount;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.shopId = shopId;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setPriceAfterDiscount(String priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", discount='" + discount + '\'' +
                ", priceAfterDiscount='" + priceAfterDiscount + '\'' +
                ", brandId='" + brandId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", shopId='" + shopId + '\'' +
                ", status='" + status + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
