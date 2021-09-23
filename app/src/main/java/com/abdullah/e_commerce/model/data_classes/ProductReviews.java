package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

public class ProductReviews {

    @SerializedName("rate_no")
    private String rateNumber;

    @SerializedName("comment")
    private String comment;

    @SerializedName("user")
    private UserReviewed userReviewed;

    public String getRateNumber() {
        return rateNumber;
    }

    public void setRateNumber(String rateNumber) {
        this.rateNumber = rateNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserReviewed getUserReviewed() {
        return userReviewed;
    }

    public void setUserReviewed(UserReviewed userReviewed) {
        this.userReviewed = userReviewed;
    }

    @Override
    public String toString() {
        return "ProductReviews{" +
                "rateNumber='" + rateNumber + '\'' +
                ", comment='" + comment + '\'' +
                ", userReviewed=" + userReviewed +
                '}';
    }
}
