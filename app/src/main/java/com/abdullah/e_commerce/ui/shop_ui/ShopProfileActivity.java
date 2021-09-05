package com.abdullah.e_commerce.ui.shop_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.data.adapters.ShopProfileAdapter;
import com.abdullah.e_commerce.databinding.ActivityShopProfileBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ShopProfileActivity extends AppCompatActivity {

    ActivityShopProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shop_profile);

        binding.activityShopProfileVp.setAdapter(new ShopProfileAdapter(this));
        new TabLayoutMediator(binding.activityShopProfileTl, binding.activityShopProfileVp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){

                    case 0:
                        tab.setText("Home");
                        break;
                    case 1:
                        tab.setText("Product");
                        break;
                    case 2:
                        tab.setText("Reviews");
                        break;

                }
            }
        }).attach();
    }
}