package com.abdullah.e_commerce.adapters;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.ProductSizeItemBinding;
import com.abdullah.e_commerce.model.data_classes.ShowedProductData;
import com.abdullah.e_commerce.ui.product_ui.ProductActivity;

public class ProductSizesAdapter extends RecyclerView.Adapter<ProductSizesAdapter.ProductSizesViewHolder>{

    private static final String TAG = "ProductSizesAdapter";

    ShowedProductData showedProductData;

    ProductActivity productActivity;

    private boolean isSelected;

    public ProductSizesAdapter(ShowedProductData showedProductData) {
        this.showedProductData = showedProductData;
    }

    @NonNull
    @Override
    public ProductSizesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        productActivity = (ProductActivity) parent.getContext();
        return new ProductSizesViewHolder(ProductSizeItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductSizesViewHolder holder, int position) {
        if(!showedProductData.getSizes().isEmpty()){
            holder.binding.productSizeItemMaterialBtn.setText(showedProductData.getSizes().get(position).getName());
        }

//        holder.binding.productSizeItemMaterialBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                holder.binding.productSizeItemMaterialBtn.setTextColor(Color.parseColor("#FF6969"));
//            }
//        });

        for (int i = 0; i < showedProductData.getColor().size(); i++) {
            holder.binding.productSizeItemMaterialBtn.setTextColor(Color.BLACK);
        }

        holder.binding.productSizeItemMaterialBtn.setOnClickListener(p-> {
            Log.i(TAG, "abdo onBindViewHolder: "+ holder.getAdapterPosition());
//            isSelected = (oldPosition != holder.getAdapterPosition());
            if (isSelected){
                unSelect(holder);
//                select(holder);
                isSelected = false;
            }else{
                holder.binding.productSizeItemMaterialBtn.setTextColor(Color.parseColor("#FF6969"));
                isSelected = true;
                productActivity.setProductSize(showedProductData.getSizes().get(position).getName());
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void unSelect(ProductSizesViewHolder holder) {
        for (int i = 0; i < showedProductData.getColor().size(); i++) {
            holder.binding.productSizeItemMaterialBtn.setTextColor(Color.BLACK);
//            isSelected = false;
            notifyDataSetChanged();
        }
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
