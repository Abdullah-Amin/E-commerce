package com.abdullah.e_commerce.ui.product_ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.adapters.ProductColorsAdapter;
import com.abdullah.e_commerce.databinding.FragmentProductBinding;
import com.abdullah.e_commerce.model.data_classes.ShowedProductData;

public class ProductFragment extends Fragment {

    FragmentProductBinding binding;
    Bundle bundle = new Bundle();

    private static final String TAG = "productFragment ";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        ShowedProductData productData = (ShowedProductData) bundle.getSerializable("productResponse");

        ProductActivity activity = (ProductActivity) requireActivity();
        binding.fragmentProductColorsRv.setAdapter(new ProductColorsAdapter(activity.getProduct()));
        Log.i(TAG, "onViewCreated: "+ activity.getProduct());

    }
}