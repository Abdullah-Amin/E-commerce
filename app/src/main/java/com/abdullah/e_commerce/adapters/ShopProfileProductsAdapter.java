package com.abdullah.e_commerce.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.FragmentShopProductItemBinding;

public class ShopProfileProductsAdapter extends
        RecyclerView.Adapter<ShopProfileProductsAdapter.ShopProfileProductsHolder>{


    @NonNull
    @Override
    public ShopProfileProductsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShopProfileProductsHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.fragment_shop_product_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShopProfileProductsHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ShopProfileProductsHolder extends RecyclerView.ViewHolder{

        private FragmentShopProductItemBinding binding;

        public ShopProfileProductsHolder(@NonNull FragmentShopProductItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
