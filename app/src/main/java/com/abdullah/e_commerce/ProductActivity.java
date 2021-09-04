package com.abdullah.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.abdullah.e_commerce.databinding.ActivityProductBinding;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    ActivityProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product);

        showFragment(binding.activityProductProductMbtn, new ProductFragment());

        unPressBtns(binding.activityProductDetailsMbtn, binding.activityProductReviewsMbtn);

        setOnClicks(binding.activityProductProductMbtn, binding.activityProductDetailsMbtn,
                binding.activityProductReviewsMbtn, new ProductFragment());

        setOnClicks(binding.activityProductDetailsMbtn, binding.activityProductProductMbtn,
                binding.activityProductReviewsMbtn, new DetailsFragment());

        setOnClicks(binding.activityProductReviewsMbtn, binding.activityProductDetailsMbtn,
                binding.activityProductProductMbtn, new ReviewsFragment());

        List<SliderItem> sliderItems = new ArrayList<>();

        sliderItems.add(new SliderItem(R.drawable.boots, "booooooots"));
        sliderItems.add(new SliderItem(R.drawable.recommended_image, "recommended"));

        binding.activityProductProductImageSlider.setSliderAdapter(new SliderAdapterExample(this, sliderItems));

        binding.activityProductAddToCartBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, CartFragment.class));
            finish();
        });
    }

    public void setOnClicks (MaterialButton pressedBtn, MaterialButton firstUnPressedBtn
            , MaterialButton secondUnPressedBtn, Fragment fragment){

        pressedBtn.setOnClickListener(v -> {
            showFragment(pressedBtn, fragment);
            unPressBtns(firstUnPressedBtn, secondUnPressedBtn);
        });
    }

    public void showFragment (MaterialButton highlightedBtn, Fragment fragment){

        highlightedBtn.setBackgroundColor(Color.WHITE);
        highlightedBtn.setTextColor(Color.RED);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.activityProductFrame.getId(), fragment)
                .commit();
    }

    public void unPressBtns ( MaterialButton firstUnPressedBtn, MaterialButton secondUnPressedBtn){
        setBtnGray(firstUnPressedBtn);
        setBtnGray(secondUnPressedBtn);
    }

    public void setBtnGray (MaterialButton btnGray){
        btnGray.setBackgroundColor(Color.TRANSPARENT);
        btnGray.setTextColor(Color.GRAY);
    }
}