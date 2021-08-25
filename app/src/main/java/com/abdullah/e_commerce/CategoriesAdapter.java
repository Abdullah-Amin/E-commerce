package com.abdullah.e_commerce;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.abdullah.e_commerce.databinding.CategoriesItemBinding;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    ArrayList<CategoryDetails> categoryDetailsArrayList;

    public CategoriesAdapter(ArrayList<CategoryDetails> categoryDetailsArrayList) {
        this.categoryDetailsArrayList = categoryDetailsArrayList;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoriesViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.categories_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {

        CategoryDetails categoryDetails = categoryDetailsArrayList.get(position);

        holder.binding.setCategoryDetail(categoryDetails);
    }

    @Override
    public int getItemCount() {
        return categoryDetailsArrayList.size();
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder {

        CategoriesItemBinding binding;

        public CategoriesViewHolder(@NonNull CategoriesItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
