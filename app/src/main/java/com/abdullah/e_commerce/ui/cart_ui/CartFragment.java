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
import android.widget.Toast;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.adapters.ShowCartProductsAdapter;
import com.abdullah.e_commerce.databinding.FragmentCartBinding;
import com.abdullah.e_commerce.model.responses.CheckoutResponse;
import com.abdullah.e_commerce.model.responses.GetCartResponse;
import com.abdullah.e_commerce.network.RetrofitSingleton;
import com.abdullah.e_commerce.network.SharedPref;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartFragment extends Fragment {

    FragmentCartBinding binding;
    NavController navController;

    Response<GetCartResponse> checkoutResponse;


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
                            checkoutResponse = response;
                            ShowCartProductsAdapter showCartProductsAdapter =
                                    new ShowCartProductsAdapter(getContext(), response.body().getData());
                            binding.fragmentCartRv.setAdapter(showCartProductsAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<GetCartResponse> call, Throwable t) {
                        Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
                    }
                });

        binding.fragmentCartCheckOutBtn.setOnClickListener(p->{

            RetrofitSingleton.connect().checkout(token)
                    .enqueue(new Callback<CheckoutResponse>() {
                        @Override
                        public void onResponse(Call<CheckoutResponse> call, Response<CheckoutResponse> response) {
                            if (response.isSuccessful()){
                                Log.i(TAG, "onResponse: "+ response.body().toString());
//                                showData(response.body());
                            }
                        }

                        @Override
                        public void onFailure(Call<CheckoutResponse> call, Throwable t) {
                            Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
                        }
                    });

            if (binding.fragmentCartRv.getAdapter().getItemCount() > 0){
                navController.navigate(R.id.action_cartFragment_to_checkoutActivity);
            }else{
                Toast.makeText(requireContext(), "There is no products to checkout", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    public void countAmount() {
//        double totalAmount = 0.0;
//        for (int i = 0; i < list.size(); i++) {
//            double amount = Double.parseDouble(list.get(i).getQuantity())
//                    * Double.parseDouble(list.get(i).getProductId().getPrice());
//            totalAmount = totalAmount + amount;
//        }
//        binding.fragmentCartPriceTv.setText(String.valueOf(totalAmount));
//    }

}