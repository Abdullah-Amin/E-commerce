package com.abdullah.e_commerce.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.SecondLatestItemBinding;
import com.abdullah.e_commerce.model.data_classes.ProductItem;
import com.abdullah.e_commerce.ui.product_ui.ProductActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SecondLatestProductAdapter extends
        RecyclerView.Adapter<SecondLatestProductAdapter.SecondLatestProductHolder> {

    private final Context context;
    private final List<ProductItem> latestProductList;

    public SecondLatestProductAdapter(Context context, List<ProductItem> latestProductList) {
        this.context = context;
        this.latestProductList = latestProductList;
    }

    @NonNull
    @Override
    public SecondLatestProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SecondLatestProductHolder(DataBindingUtil.inflate
                (LayoutInflater.from(parent.getContext()), R.layout.second_latest_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SecondLatestProductHolder holder, int position) {
        ProductItem latestProduct = latestProductList.get(position);

        holder.binding.fragmentHomeSecondProductName.setText(latestProduct.getLatestProductName());
        holder.binding.fragmentHomeSecondProductPrice.setText((latestProduct.getLatestProductPrice()));

        Picasso.get()
                .load(String.valueOf(latestProduct.getLatestProductImages().get(0).getLatestProductImage()))
                .placeholder(R.drawable.place_holder_image)
                .into(holder.binding.fragmentHomeThirdPicUnderLatest);

        holder.binding.fragmentHomeThirdCv.setOnClickListener(v->{
            Intent intent = new Intent(context.getApplicationContext(), ProductActivity.class);
            intent.putExtra("productId", latestProduct.getLatestProductId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return latestProductList.size();
    }

    public static class SecondLatestProductHolder extends RecyclerView.ViewHolder {

        SecondLatestItemBinding binding;

        public SecondLatestProductHolder(@NonNull SecondLatestItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
