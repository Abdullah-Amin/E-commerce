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
import com.abdullah.e_commerce.adapters.ProductSizesAdapter;
import com.abdullah.e_commerce.databinding.FragmentProductBinding;

public class ProductFragment extends Fragment {

    FragmentProductBinding binding;

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

//        Log.i(TAG, "onCreateView: "+ getArguments().getSerializable("showedProductData"));

//        ShowedProductData showedProductData = (ShowedProductData) getArguments().getSerializable("showedProductData");

        ProductActivity productActivity = (ProductActivity) getActivity();

        Log.i(TAG, "onViewCreated: "+ productActivity.getProductData());

        assert productActivity != null;
        binding.fragmentProductColorsRv.setAdapter(new ProductColorsAdapter(productActivity.getProductData()));
        binding.fragmentProductSizesRv.setAdapter(new ProductSizesAdapter(productActivity.getProductData()));

//        if(getArguments() != null){
//            binding.fragmentProductColorsRv.setAdapter(new ProductColorsAdapter(
//                    (ShowedProductData) getArguments().getSerializable("showedProductData")));
//        }
    }
}