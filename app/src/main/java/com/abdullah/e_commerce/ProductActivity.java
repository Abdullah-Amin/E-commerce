package com.abdullah.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.abdullah.e_commerce.databinding.ActivityProductBinding;
import com.google.android.material.button.MaterialButton;

public class ProductActivity extends AppCompatActivity {

    ActivityProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product);

        binding.activityProductProductMbtn.setBackgroundColor(Color.WHITE);
        binding.activityProductProductMbtn.setTextColor(Color.RED);

        binding.activityProductDetailsMbtn.setBackgroundColor(Color.TRANSPARENT);
        binding.activityProductDetailsMbtn.setTextColor(Color.GRAY);

        binding.activityProductReviewsMbtn.setBackgroundColor(Color.TRANSPARENT);
        binding.activityProductReviewsMbtn.setTextColor(Color.GRAY);



        binding.activityProductProductMbtn.setOnClickListener(v -> {
            binding.activityProductProductMbtn.setBackgroundColor(Color.WHITE);
            binding.activityProductProductMbtn.setTextColor(Color.RED);

            binding.activityProductDetailsMbtn.setBackgroundColor(Color.TRANSPARENT);
            binding.activityProductDetailsMbtn.setTextColor(Color.GRAY);

            binding.activityProductReviewsMbtn.setBackgroundColor(Color.TRANSPARENT);
            binding.activityProductReviewsMbtn.setTextColor(Color.GRAY);
        });

        binding.activityProductDetailsMbtn.setOnClickListener(v -> {
            binding.activityProductDetailsMbtn.setBackgroundColor(Color.WHITE);
            binding.activityProductDetailsMbtn.setTextColor(Color.RED);

            binding.activityProductProductMbtn.setBackgroundColor(Color.TRANSPARENT);
            binding.activityProductProductMbtn.setTextColor(Color.GRAY);

            binding.activityProductReviewsMbtn.setBackgroundColor(Color.TRANSPARENT);
            binding.activityProductReviewsMbtn.setTextColor(Color.GRAY);
        });

        binding.activityProductReviewsMbtn.setOnClickListener(v -> {
            binding.activityProductReviewsMbtn.setBackgroundColor(Color.WHITE);
            binding.activityProductReviewsMbtn.setTextColor(Color.RED);

            binding.activityProductDetailsMbtn.setBackgroundColor(Color.TRANSPARENT);
            binding.activityProductDetailsMbtn.setTextColor(Color.GRAY);

            binding.activityProductProductMbtn.setBackgroundColor(Color.TRANSPARENT);
            binding.activityProductProductMbtn.setTextColor(Color.GRAY);
        });

    }
}