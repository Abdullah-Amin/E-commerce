package com.abdullah.e_commerce.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.ProductAddedToCartItemBinding;
import com.abdullah.e_commerce.model.data_classes.DataItem;
import com.abdullah.e_commerce.network.RetrofitSingleton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShowCartProductsAdapter extends RecyclerView.Adapter<ShowCartProductsAdapter.ShowCartProductsViewHolder>{

    Context context;
    List<DataItem> showedData;

    public ShowCartProductsAdapter(Context context, List<DataItem> showedData) {
        this.context = context;
        this.showedData = showedData;
    }

    @NonNull
    @Override
    public ShowCartProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShowCartProductsViewHolder(ProductAddedToCartItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShowCartProductsViewHolder holder, int position) {

        DataItem dataItem = showedData.get(position);

//        holder.binding.productAddedToCartItemItemImage.setBackgroundResource(
//                Integer.parseInt(showedData.get(position).
//                        getProductId().getImages().get(0).getImage()));

        Picasso.get()
                .load(dataItem.getProductId().getImages().get(0).getImage())
                .placeholder(R.drawable.place_holder_image)
                .into(holder.binding.productAddedToCartItemItemImage);

        holder.binding.productAddedToCartItemItemName.setText(
                showedData.get(position).getProductId().getItemName());

        holder.binding.productAddedToCartItemItemDetails.setText(
                showedData.get(position).getProductId().getDescription());

        holder.binding.productAddedToCartItemItemPrice.setText(
                showedData.get(position).getProductId().getPriceAfterDiscount());

        holder.binding.productAddedToCartItemItemCounterTv.setText(
                showedData.get(position).getQuantity());

//        holder.binding.productAddedToCartItemItemAddIv.setOnClickListener(p->{
//            RetrofitSingleton.connect().
//        });
    }

    @Override
    public int getItemCount() {
        return showedData.size();
    }

    public static class ShowCartProductsViewHolder extends RecyclerView.ViewHolder {

        ProductAddedToCartItemBinding binding;

        public ShowCartProductsViewHolder(@NonNull ProductAddedToCartItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
