package com.abdullah.e_commerce.adapters;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdullah.e_commerce.databinding.ProductColorItemBinding;
import com.abdullah.e_commerce.model.data_classes.ProductColor;
import com.abdullah.e_commerce.model.data_classes.ShowedProductData;

import java.util.List;

public class ProductColorsAdapter extends RecyclerView.Adapter<ProductColorsAdapter.ProductColorsViewHolder> {

//    List<ProductColor> productColors;
    ShowedProductData showedProductData;

    private static final String TAG = "ProductColorsAdapter";

    public ProductColorsAdapter(ShowedProductData showedProductData) {
//        this.productColors = productColors;
        this.showedProductData = showedProductData;
    }

    @NonNull
    @Override
    public ProductColorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductColorsViewHolder(ProductColorItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductColorsViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: colors "+ showedProductData);
        if (!showedProductData.getColor().isEmpty()) {
            Log.i(TAG, "onBindViewHolder: "+ showedProductData.getColor().get(position).getColorId());
            holder.binding.productColorItemFloatingActionBtn.setBackgroundColor(Color.parseColor(
                    showedProductData.getColor().get(position).getColorId()));
        }
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "getItemCount: "+ showedProductData);
        return showedProductData.getColor().size();
    }

    public static class ProductColorsViewHolder extends RecyclerView.ViewHolder {

        ProductColorItemBinding binding;

        public ProductColorsViewHolder(@NonNull ProductColorItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
