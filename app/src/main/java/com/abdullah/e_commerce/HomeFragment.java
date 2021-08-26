package com.abdullah.e_commerce;

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

import com.abdullah.e_commerce.databinding.FragmentHomeBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    NavController navController;

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

//        Glide.with(view.getContext())
//                .load(imageUrl).apply(new RequestOptions().circleCrop())
//                .into();

        Log.i(TAG, "onViewCreated: " + categoryDetailsArrayList.size());

        binding.fragmentHomeCategoriesRv.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        binding.fragmentHomeCategoriesRv.setAdapter(new CategoriesAdapter(categoryDetailsArrayList));
    }

    private void setCategoryDetails(int categoryImage, String categoryName) {
        categoryDetailsArrayList.add(new CategoryDetails(categoryImage, categoryName));
    }
}