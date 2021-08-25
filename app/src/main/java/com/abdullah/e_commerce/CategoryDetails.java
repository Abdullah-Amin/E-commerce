package com.abdullah.e_commerce;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class CategoryDetails {

    int categoryImage;
    String categoryName;

    public CategoryDetails(int categoryImage, String categoryName) {
        this.categoryImage = categoryImage;
        this.categoryName = categoryName;
    }

    public int getCategoryImage() {
        return categoryImage;
    }

//    @BindingAdapter({})
    public void setCategoryImage(int categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
