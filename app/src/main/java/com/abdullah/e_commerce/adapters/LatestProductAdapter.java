package com.abdullah.e_commerce.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.LatestItemBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LatestProductAdapter extends
        RecyclerView.Adapter<LatestProductAdapter.LatestProductHolder> {

    private Context context;
    private ArrayList<Integer> latestProductImageList;

    public LatestProductAdapter(Context context, ArrayList<Integer> latestProductImageList) {
        this.context = context;
        this.latestProductImageList = latestProductImageList;
    }

    @NonNull
    @Override
    public LatestProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LatestProductHolder(DataBindingUtil.inflate
                (LayoutInflater.from(parent.getContext()), R.layout.latest_item, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LatestProductHolder holder, int position) {
        Picasso.get()
                .load(latestProductImageList.get(position))
                .placeholder(R.drawable.place_holder_image)
                .into(holder.binding.latestItemIv);

        holder.binding.latestItemSeeMoreIv.setVisibility(View.GONE);
        holder.binding.latestItemTv.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return latestProductImageList.size();
    }

    public static class LatestProductHolder extends RecyclerView.ViewHolder {

        private LatestItemBinding binding;

        public LatestProductHolder(@NonNull LatestItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
