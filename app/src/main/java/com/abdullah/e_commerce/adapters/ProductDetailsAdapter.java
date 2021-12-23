package com.abdullah.e_commerce.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdullah.e_commerce.databinding.ProductDetailsItemBinding;

public class ProductDetailsAdapter extends
        RecyclerView.Adapter<ProductDetailsAdapter.ProductDetailsViewHolder>{

    @NonNull
    @Override
    public ProductDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductDetailsViewHolder(ProductDetailsItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductDetailsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ProductDetailsViewHolder extends RecyclerView.ViewHolder {

        ProductDetailsItemBinding binding;

        public ProductDetailsViewHolder(@NonNull ProductDetailsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
