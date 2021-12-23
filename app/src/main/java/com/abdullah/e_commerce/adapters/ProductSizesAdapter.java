package com.abdullah.e_commerce.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdullah.e_commerce.databinding.ProductSizeItemBinding;
import com.abdullah.e_commerce.model.data_classes.ShowedProductData;

public class ProductSizesAdapter extends RecyclerView.Adapter<ProductSizesAdapter.ProductSizesViewHolder>{

    private static final String TAG = "ProductSizesAdapter";

    ShowedProductData showedProductData;

    public ProductSizesAdapter(ShowedProductData showedProductData) {
        this.showedProductData = showedProductData;
    }

    @NonNull
    @Override
    public ProductSizesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductSizesViewHolder(ProductSizeItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductSizesViewHolder holder, int position) {
        if(!showedProductData.getSizes().isEmpty()){
            holder.binding.productSizeItemMaterialBtn.setText(showedProductData.getSizes().get(position).getName());
        }

        holder.binding.productSizeItemMaterialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.binding.productSizeItemMaterialBtn.setTextColor(Color.parseColor("#FF6969"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return showedProductData.getSizes().size();
    }

    public static class ProductSizesViewHolder extends RecyclerView.ViewHolder{

        ProductSizeItemBinding binding;

        public ProductSizesViewHolder(@NonNull ProductSizeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
