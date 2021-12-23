package com.abdullah.e_commerce.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdullah.e_commerce.databinding.ProductAddedToCartItemBinding;
import com.abdullah.e_commerce.model.responses.CartResponse;

import retrofit2.Response;

public class ShowCartProductsAdapter extends RecyclerView.Adapter<ShowCartProductsAdapter.ShowCartProductsViewHolder>{

    Context context;
    Response<CartResponse> response;

    public ShowCartProductsAdapter(Context context, Response<CartResponse> response) {
        this.context = context;
        this.response = response;
    }

    @NonNull
    @Override
    public ShowCartProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShowCartProductsViewHolder(ProductAddedToCartItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShowCartProductsViewHolder holder, int position) {

        holder.binding.productAddedToCartItemItemImage.setBackgroundResource(
                Integer.parseInt(response.body().getShowedData().get(position).
                        getProductId().getLatestProductImages().get(0).getProductImage()));

        holder.binding.productAddedToCartItemItemName.setText(
                response.body().getShowedData().get(position).getProductId().getLatestProductName());

        holder.binding.productAddedToCartItemItemDetails.setText(
                response.body().getShowedData().get(position).getProductId().getLatestProductDescription());

        holder.binding.productAddedToCartItemItemPrice.setText(
                response.body().getShowedData().get(position).getProductId().getLatestProductPrice());

        holder.binding.productAddedToCartItemItemCounterTv.setText(
                response.body().getShowedData().get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        return response.body().getShowedData().size();
    }

    public static class ShowCartProductsViewHolder extends RecyclerView.ViewHolder {

        ProductAddedToCartItemBinding binding;

        public ShowCartProductsViewHolder(@NonNull ProductAddedToCartItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
