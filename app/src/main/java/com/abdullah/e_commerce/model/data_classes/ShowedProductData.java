package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShowedProductData {

    @SerializedName("item_id")
    private int showedProductId;

    @SerializedName("item_name")
    private String showedProductName;

    private String description;

    @SerializedName("item_price")
    private String showedProductPrice;

    @SerializedName("stock_qty")
    private String showedProductStockQty;

    @SerializedName("currency_code")
    private String showedProductCurrencyCode;

    @SerializedName("item_image_url")
    private String showedProductImageUrl;

    @SerializedName("sizes")
    List<ProductSizes> showedProductSizes;

    @SerializedName("review")
    List<ProductReviews> showedProductReviews;

    @SerializedName("details")
    List<ProductDetails> showedProductDetails;

    @SerializedName("color")
    List<ProductColor> showedProductColor;

    @SerializedName("images")
    List<ProductImages> showedProductImages;

    public int getShowedProductId() {
        return showedProductId;
    }

    public void setShowedProductId(int showedProductId) {
        this.showedProductId = showedProductId;
    }

    public String getShowedProductName() {
        return showedProductName;
    }

    public void setShowedProductName(String showedProductName) {
        this.showedProductName = showedProductName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShowedProductPrice() {
        return showedProductPrice;
    }

    public void setShowedProductPrice(String showedProductPrice) {
        this.showedProductPrice = showedProductPrice;
    }

    public String getShowedProductStockQty() {
        return showedProductStockQty;
    }

    public void setShowedProductStockQty(String showedProductStockQty) {
        this.showedProductStockQty = showedProductStockQty;
    }

    public String getShowedProductCurrencyCode() {
        return showedProductCurrencyCode;
    }

    public void setShowedProductCurrencyCode(String showedProductCurrencyCode) {
        this.showedProductCurrencyCode = showedProductCurrencyCode;
    }

    public String getShowedProductImageUrl() {
        return showedProductImageUrl;
    }

    public void setShowedProductImageUrl(String showedProductImageUrl) {
        this.showedProductImageUrl = showedProductImageUrl;
    }

    public List<ProductSizes> getShowedProductSizes() {
        return showedProductSizes;
    }

    public void setShowedProductSizes(List<ProductSizes> showedProductSizes) {
        this.showedProductSizes = showedProductSizes;
    }

    public List<ProductReviews> getShowedProductReviews() {
        return showedProductReviews;
    }

    public void setShowedProductReviews(List<ProductReviews> showedProductReviews) {
        this.showedProductReviews = showedProductReviews;
    }

    public List<ProductDetails> getShowedProductDetails() {
        return showedProductDetails;
    }

    public void setShowedProductDetails(List<ProductDetails> showedProductDetails) {
        this.showedProductDetails = showedProductDetails;
    }

    public List<ProductColor> getShowedProductColor() {
        return showedProductColor;
    }

    public void setShowedProductColor(List<ProductColor> showedProductColor) {
        this.showedProductColor = showedProductColor;
    }

    public List<ProductImages> getShowedProductImages() {
        return showedProductImages;
    }

    public void setShowedProductImages(List<ProductImages> showedProductImages) {
        this.showedProductImages = showedProductImages;
    }

    @Override
    public String toString() {
        return "ShowedProductData{" +
                "showedProductId=" + showedProductId +
                ", showedProductName='" + showedProductName + '\'' +
                ", description='" + description + '\'' +
                ", showedProductPrice='" + showedProductPrice + '\'' +
                ", showedProductStockQty='" + showedProductStockQty + '\'' +
                ", showedProductCurrencyCode='" + showedProductCurrencyCode + '\'' +
                ", showedProductImageUrl='" + showedProductImageUrl + '\'' +
                ", showedProductSizes=" + showedProductSizes +
                ", showedProductReviews=" + showedProductReviews +
                ", showedProductDetails=" + showedProductDetails +
                ", showedProductColor=" + showedProductColor +
                ", showedProductImages=" + showedProductImages +
                '}';
    }
}
