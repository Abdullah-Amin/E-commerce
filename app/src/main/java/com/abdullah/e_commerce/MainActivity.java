package com.abdullah.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.abdullah.e_commerce.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.mainActivityVp.setAdapter(new PagerAdapter(MainActivity.this));

        TabLayoutMediator mediator = new TabLayoutMediator(binding.mainActivityTl, binding.mainActivityVp, (tab, position) -> {

            switch (position){
                case 0:
                    tab.setText("Sign up");
                    break;
                case 1:
                    tab.setText("Login");
                    break;
                case 2:
                    tab.setText("Forgot password");
                    break;
            }

        });
        mediator.attach();

    }
}