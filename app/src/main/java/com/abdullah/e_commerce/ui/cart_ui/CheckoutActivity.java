package com.abdullah.e_commerce.ui.cart_ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.ActivityCheckoutBinding;

public class CheckoutActivity extends AppCompatActivity {

    ActivityCheckoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_checkout);

        binding.activityCheckoutPlaceOrderBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, OrderPlacedActivity.class));
        });
    }
}