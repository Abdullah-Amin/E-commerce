package com.abdullah.e_commerce.ui.main_ui;

import android.os.Bundle;
import android.util.Log;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.ActivityHomeBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_cart,
                R.id.navigation_profile, R.id.navigation_more)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.activityHomeNavView, navController);


        this.token = getIntent().getStringExtra("token");

        String activityName = getIntent().getStringExtra("productActivity");

        if(activityName != null && activityName.equals("ProductActivity")){
            navController.navigate(R.id.action_navigation_home_to_navigation_cart);
        }
        else{
            Log.i("asd", "onCreate: ---------------------");
        }
    }

    public String getToken(){
        return this.token;
    }

}