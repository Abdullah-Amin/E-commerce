package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

public class UserReviewed {

    @SerializedName("name")
    private String reviewerName;

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }
}
