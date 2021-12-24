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
import com.abdullah.e_commerce.from_json_to_pojo.GetCartResponse;
import com.abdullah.e_commerce.model.responses.CartResponse;
import com.abdullah.e_commerce.network.RetrofitSingleton;
import com.abdullah.e_commerce.network.SharedPref;
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

        String token = SharedPref.read(SharedPref.Token, null);

        RetrofitSingleton.connect().showCartProducts(token)
                .enqueue(new Callback<GetCartResponse>() {
                    @Override
                    public void onResponse(Call<GetCartResponse> call, Response<GetCartResponse> response) {
                        if (response.isSuccessful()){
                            Log.i(TAG, "onResponse: "+ response.body());
                            binding.fragmentCartRv.setAdapter(new ShowCartProductsAdapter(getContext(), response.body().getData()));
                        }
                    }

                    @Override
                    public void onFailure(Call<GetCartResponse> call, Throwable t) {
                        Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
                    }
                });
    }
}