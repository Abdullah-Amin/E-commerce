package com.abdullah.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;

import android.os.Bundle;
import android.view.MenuItem;

import com.abdullah.e_commerce.databinding.ActivityHomeBinding;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(HomeActivity.this, R.layout.activity_home);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.activityHomeFrame.getId(), new HomeFragment())
                .commit();

        binding.activityHomeBnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(binding.activityHomeFrame.getId(), new HomeFragment())
                                .commit();
                        return true;

                    case R.id.search:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(binding.activityHomeFrame.getId(), new SearchFragment())
                                .commit();
                        return true;
                }
                return true;
            }
        });
    }
}