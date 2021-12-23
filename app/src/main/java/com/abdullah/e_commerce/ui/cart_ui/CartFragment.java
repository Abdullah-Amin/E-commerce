package com.abdullah.e_commerce.ui.cart_ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.adapters.ShowCartProductsAdapter;
import com.abdullah.e_commerce.databinding.FragmentCartBinding;
import com.abdullah.e_commerce.model.responses.CartResponse;
import com.abdullah.e_commerce.network.RetrofitSingleton;
import com.abdullah.e_commerce.ui.cart_ui.CheckoutActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartFragment extends Fragment {

    FragmentCartBinding binding;
    NavController navController;

    private static final String TAG = "CartFragment";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.fragmentCartCheckOutBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), CheckoutActivity.class);
            startActivity(intent);
//            navController.navigate(R.id.action_cartFragment_to_checkoutActivity);
        });

        RetrofitSingleton.connect().showCartProducts("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiM2RiMjE3NjI5N2FiOTkxMjVjZTAxMWU3NzFhNGRmZGQ3Zjg0NDQzNDg5MzAzNmRkYzdkYjlkODM3ODI0ZWJlZmM1ODY3OGYzOTIzOGQ3MzYiLCJpYXQiOjE2MzUzNjg1MzYsIm5iZiI6MTYzNTM2ODUzNiwiZXhwIjoxNjY2OTA0NTM2LCJzdWIiOiI3NCIsInNjb3BlcyI6W119.TvC1P65I018rXUm809pngvyMR-pjurDL9qjkIMDbbqSXKXGzKk6tE87yWe8M_zXhFuBYUD2JEm2p9lYCc8w4D6xt_0oSLBsTDmK1ydAahR3sUwAgZ0B4ryO2uQAhZr6fEbbLCbfXeqtMeMDridkLWHhU9RHH4ryjRm1YToGlRgEOighiQKfv-Qwy0b3pzauvzLJ3RBsuk1NelM0kc8k5hsPwu29VIkbIC87-Hfr0KTYd5m78SkvXIhhJ4cm6icY0dCD-MbnhBeBoHplwZ1okpnpWoqWWV0CjFJ24fsUgQEgPNYmLjGEd-UsHAnwbPykvS3hNt99ac7g4zVnFY16R1N4n6GGuYm0nr9w2JZ_wx2anh2hvNaE90ubZoAO8Tozy8WDSGtFimbRbJmw59JEmWfieBafohB4t3veK1MxLQjvfWLKWP84Zu7VGnd7Vtw6feRgEM3hRtwrhZ1all9tzhD644JL3lsvehq2AHAevavoJ3GwHZTFJAUauy_XOLz-Tuqv4VFmCKNr6xYDj7gkfdbuwGcG72BEbAhUorl4nqD1Qij2NL1nh47AxF4cDf8sQ9syVkP6hUUHIFjADmS-1qiZ1lEsXYwV8CUckpi04cH7v8ZF89Nwz6FCSHSeTw_EqKAhhgdRm_HjIJ9ZzWQI2vyR5VuJHTrTNpMf_8VY4ORw")
                .enqueue(new Callback<CartResponse>() {
                    @Override
                    public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
                        if (response.isSuccessful()){
                            Log.i(TAG, "onResponse: "+ response.body());
                            binding.fragmentCartRv.setAdapter(new ShowCartProductsAdapter(getContext(), response));
                        }
                    }

                    @Override
                    public void onFailure(Call<CartResponse> call, Throwable t) {
                        Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
                    }
                });
    }
}