package com.abdullah.e_commerce.ui.cart_ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.ActivityCheckoutBinding;
import com.abdullah.e_commerce.model.data_classes.CheckoutUserData;
import com.abdullah.e_commerce.model.responses.CheckoutResponse;
import com.abdullah.e_commerce.network.RetrofitSingleton;
import com.abdullah.e_commerce.network.SharedPref;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckoutActivity extends AppCompatActivity {

    ActivityCheckoutBinding binding;

    private static final String TAG = "CheckoutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_checkout);

        binding.activityCheckoutPlaceOrderBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, OrderPlacedActivity.class));
        });

        String token = SharedPref.read("token", null);

        RetrofitSingleton.connect().checkout(token)
                .enqueue(new Callback<CheckoutResponse>() {
                    @Override
                    public void onResponse(Call<CheckoutResponse> call, Response<CheckoutResponse> response) {
                        if (response.isSuccessful()){
                            Log.i(TAG, "onResponse: "+ response.body().toString());
                            showData(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<CheckoutResponse> call, Throwable t) {
                        Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
                    }
                });
    }

    private void showData(CheckoutResponse checkoutResponse) {
        if (checkoutResponse.isStatus() && checkoutResponse.getItems() != null){
            binding.activityCheckoutShipAddressTv.setVisibility(View.GONE);
            binding.activityCheckoutClientNameTv.setText(checkoutResponse.getCheckoutUserData().getName());
            binding.activityCheckoutClientAddressTv.setText(checkoutResponse.getCheckoutUserData().getAddressId().toString());
        }else{
            binding.activityCheckoutShipAddressTv.setVisibility(View.GONE);
            binding.activityCheckoutClientNameTv.setVisibility(View.GONE);
            binding.activityCheckoutClientAddressTv.setVisibility(View.GONE);
            binding.activityCheckoutGotoBtn.setVisibility(View.GONE);
            binding.activityCheckoutPriceTv.setText("$0");

            Toast.makeText(this, "No product details to show", Toast.LENGTH_SHORT).show();
        }

    }
}