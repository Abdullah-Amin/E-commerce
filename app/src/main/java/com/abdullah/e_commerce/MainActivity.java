package com.abdullah.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.abdullah.e_commerce.databinding.ActivityMainBinding;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().hide();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.mainActivityVp.setAdapter(new PagerAdapter(MainActivity.this));

        binding.mainActivityLoginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mainActivitySignupTv.setVisibility(View.GONE);
                binding.mainActivityLoginTv.setTextColor(Color.BLACK);
                binding.mainActivitySignupTv.setVisibility(View.VISIBLE);
                binding.mainActivitySignupTv.setLeft(View.FOCUS_LEFT);
//                binding.mainActivityLl.removeView(binding.mainActivitySignupTv);
//                binding.mainActivityLl.addView(binding.mainActivitySignupTv, 40, 33);
            }
        });

        binding.mainActivityForgotPasswordTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mainActivitySignupTv.setVisibility(View.GONE);
                binding.mainActivityLoginTv.setVisibility(View.GONE);
                binding.mainActivityForgotPasswordTv.setTextColor(Color.BLACK);
                binding.mainActivitySignupTv.setLeft(View.FOCUS_LEFT);
                binding.mainActivityLoginTv.setLeft(View.FOCUS_LEFT);
//                binding.mainActivityLl.removeView(binding.mainActivitySignupTv);
//                binding.mainActivityLl.addView(binding.mainActivitySignupTv, 40, 33);
            }
        });

    }
}