package com.abdullah.e_commerce.adapters;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.ProductColorItemBinding;
import com.abdullah.e_commerce.model.data_classes.ShowedProductData;
import com.abdullah.e_commerce.ui.product_ui.ProductActivity;


public class ProductColorsAdapter extends RecyclerView.Adapter<ProductColorsAdapter.ProductColorsViewHolder> {

//    List<ProductColor> productColors;
    ShowedProductData showedProductData;

    private static final String TAG = "ProductColorsAdapter";

    private boolean isSelected;
    int oldPosition;

    ProductActivity productActivity;

    public ProductColorsAdapter(ShowedProductData showedProductData) {
//        this.productColors = productColors;
        this.showedProductData = showedProductData;
    }

    @NonNull
    @Override
    public ProductColorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        productActivity = (ProductActivity) parent.getContext();
        return new ProductColorsViewHolder(ProductColorItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductColorsViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: colors "+ showedProductData);
        if (!showedProductData.getColor().isEmpty()) {
            Log.i(TAG, "onBindViewHolder: "+ showedProductData.getColor().get(position).getColorId());

            holder.binding.productColorItemColorTv.setCardBackgroundColor(Color.parseColor(
                    showedProductData.getColor().get(position).getColorId()));

//            holder.binding.productColorItemColorTv.setBackgroundResource(R.drawable.search_corners);
//            holder.binding.productColorItemFloatingActionBtn.setBackgroundColor(Color.parseColor(
//                    showedProductData.getColor().get(position).getColorId()));
        }

        for (int i = 0; i < showedProductData.getColor().size(); i++) {
            holder.binding.productColorItemSelectIv.setVisibility(View.GONE);
        }

        holder.binding.productColorItemColorTv.setOnClickListener(p-> {
            Log.i(TAG, "abdo onBindViewHolder: "+ holder.getAdapterPosition());
//            isSelected = (oldPosition != holder.getAdapterPosition());
            if (isSelected){
                unSelect(holder);
//                select(holder);
                isSelected = false;
            }else{
                holder.binding.productColorItemSelectIv.setImageResource(R.drawable.ic_dark_select);
                holder.binding.productColorItemSelectIv.setVisibility(View.VISIBLE);
                isSelected = true;
                productActivity.setProductColor(showedProductData.getColor().get(position).getColorId());
                oldPosition = holder.getAdapterPosition();
            }
        });
    }

//    private void select(ProductColorsViewHolder holder) {
//        holder.binding.productColorItemSelectIv.setImageResource(R.drawable.ic_dark_select);
//        holder.binding.productColorItemSelectIv.setVisibility(View.VISIBLE);
//    }

    @SuppressLint("NotifyDataSetChanged")
    private void unSelect(ProductColorsViewHolder holder) {
        for (int i = 0; i < showedProductData.getColor().size(); i++) {
            holder.binding.productColorItemSelectIv.setVisibility(View.GONE);
//            isSelected = false;
            notifyDataSetChanged();
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
