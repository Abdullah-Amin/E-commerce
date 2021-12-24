package com.abdullah.e_commerce.ui.main_ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;

import android.os.Bundle;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.ActivityMainBinding;
import com.abdullah.e_commerce.network.SharedPref;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    NavController navController;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        SharedPref.init(this);

    }

}