package com.abdullah.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.abdullah.e_commerce.databinding.ActivityProductBinding;

public class ProductActivity extends AppCompatActivity {

    ActivityProductBinding binding;
    NavController navController;

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
    }
}