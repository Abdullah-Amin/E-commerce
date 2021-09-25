package com.abdullah.e_commerce.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.SecondLatestItemBinding;
import com.abdullah.e_commerce.model.data_classes.LatestProduct;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SecondLatestProductAdapter extends
        RecyclerView.Adapter<SecondLatestProductAdapter.SecondLatestProductHolder> {

    private Context context;
    private List<LatestProduct> latestProductList;

    public SecondLatestProductAdapter(Context context, List<LatestProduct> latestProductList) {
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
        LatestProduct latestProduct = latestProductList.get(position);

        holder.binding.fragmentHomeSecondProductName.setText(latestProduct.getLatestProductName());
        holder.binding.fragmentHomeSecondProductPrice.setText((latestProduct.getLatestProductPrice()));

        Picasso.get()
                .load(R.drawable.shirt_image)
                .placeholder(R.drawable.place_holder_image)
                .into(holder.binding.fragmentHomeThirdPicUnderLatest);
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
