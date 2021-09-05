package com.abdullah.e_commerce.ui.cart_ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.ActivityOrderPlacedBinding;

public class OrderPlacedActivity extends AppCompatActivity {

    ActivityOrderPlacedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_placed);


    }
}