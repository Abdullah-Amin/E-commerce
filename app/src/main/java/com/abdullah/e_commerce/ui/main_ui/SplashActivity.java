package com.abdullah.e_commerce.ui.main_ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.ActivitySplashBinding;
import com.abdullah.e_commerce.network.SharedPref;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding;
    Intent intent = new Intent();
    private static final String TAG = "SplashActivity";

    String token =  SharedPref.read(SharedPref.Token, null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        CountDownTimer countDownTimer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {
                binding.activitySplashPb.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinish() {
                if (token != null){
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    finish();
                }else{
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }
        }.start();

//        runOnUiThread(() -> {
//
//        });


    }
}