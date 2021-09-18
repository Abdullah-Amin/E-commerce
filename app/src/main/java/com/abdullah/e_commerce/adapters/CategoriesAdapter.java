package com.abdullah.e_commerce.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.model.data_classes.CategoryDetails;
import com.abdullah.e_commerce.databinding.CategoriesItemBinding;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    ArrayList<CategoryDetails> categoryDetailsArrayList;

    public CategoriesAdapter(ArrayList<CategoryDetails> categoryDetailsArrayList) {
        this.categoryDetailsArrayList = categoryDetailsArrayList;
    }

    public int getImages(CategoryDetails image){
        return image.getCategoryImage();
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

        holder.binding.categoriesItemTv.setText(categoryDetails.getCategoryName());

        holder.binding.categoriesItemIv.setImageResource(getImages(categoryDetailsArrayList.get(position)));
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
