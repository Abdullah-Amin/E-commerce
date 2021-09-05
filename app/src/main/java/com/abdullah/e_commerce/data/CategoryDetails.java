package com.abdullah.e_commerce.data;

import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.abdullah.e_commerce.databinding.FragmentHomeBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class CategoryDetails {

//    ImageView image;
    int categoryImage;
    String categoryName;


    public CategoryDetails(int categoryImage, String categoryName) {
//        this.image = image;
        this.categoryImage = categoryImage;
        this.categoryName = categoryName;
    }

    public int getCategoryImage() {
        return categoryImage;
    }

//    @BindingAdapter({"android:src"})
    public void setCategoryImage(int categoryImage) {
        this.categoryImage = categoryImage;

//        imageView.setImageResource(categoryImage);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
