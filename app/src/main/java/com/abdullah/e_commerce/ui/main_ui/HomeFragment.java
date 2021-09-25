package com.abdullah.e_commerce.ui.main_ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abdullah.e_commerce.adapters.CategoriesAdapter;
import com.abdullah.e_commerce.adapters.LatestProductAdapter;
import com.abdullah.e_commerce.adapters.SecondLatestProductAdapter;
import com.abdullah.e_commerce.model.data_classes.CategoryDetails;
import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.FragmentHomeBinding;
import com.abdullah.e_commerce.model.data_classes.LatestProduct;
import com.abdullah.e_commerce.model.reponses.LatestProductResponse;
import com.abdullah.e_commerce.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    NavController navController;

    List<LatestProduct> latestProductList;
    ArrayList<Integer> latestProductImageList = new ArrayList<>();

    ArrayList<CategoryDetails> categoryDetailsArrayList = new ArrayList<>();

    private static final String TAG = "HomeFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setCategoryDetails(R.drawable.apparel_image, "Apparel");
        setCategoryDetails(R.drawable.beauty_image, "Beauty");
        setCategoryDetails(R.drawable.shoes_image, "Shoes");
        setCategoryDetails(R.drawable.electronics_image, "Electronics");
        setCategoryDetails(R.drawable.furniture_image, "Furniture");
        setCategoryDetails(R.drawable.home_image, "Home");
        setCategoryDetails(R.drawable.stationary_image, "Stationary");

        latestProductImageList.add(R.drawable.latest_picture);
        latestProductImageList.add(R.drawable.latest_image_two);

        binding.fragmentHomeLatestRv.setAdapter(new LatestProductAdapter(getContext(), latestProductImageList));

//        Glide.with(view.getContext())
//                .load(imageUrl).apply(new RequestOptions().circleCrop())
//                .into();

        Log.i(TAG, "onViewCreated: " + categoryDetailsArrayList.size());

        binding.fragmentHomeCategoriesRv.setAdapter(new CategoriesAdapter(categoryDetailsArrayList));

        connectAndGetLatestProducts();
    }

    private void connectAndGetLatestProducts() {
        RetrofitSingleton.connect().getLatestProducts()
                .enqueue(new Callback<LatestProductResponse>() {
                    @Override
                    public void onResponse(Call<LatestProductResponse> call, Response<LatestProductResponse> response) {
                        if(response.isSuccessful()){
                            Log.i(TAG, "onResponse: "+response.body().toString());
                            latestProductList = response.body().getLatestProductList();
                            binding.fragmentHomeSecondLatestRv.setAdapter(new SecondLatestProductAdapter(getContext(), latestProductList));

                        }else {
                            Log.i(TAG, "onResponse: else ");
                        }
                    }

                    @Override
                    public void onFailure(Call<LatestProductResponse> call, Throwable t) {
                        Log.i(TAG, "onFailure: "+t.getLocalizedMessage());
                    }
                });
    }

    private void setCategoryDetails(int categoryImage, String categoryName) {
        categoryDetailsArrayList.add(new CategoryDetails(categoryImage, categoryName));
    }
}