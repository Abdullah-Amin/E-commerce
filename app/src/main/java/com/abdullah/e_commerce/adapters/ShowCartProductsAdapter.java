package com.abdullah.e_commerce.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.ProductAddedToCartItemBinding;
import com.abdullah.e_commerce.model.data_classes.DataItem;
import com.abdullah.e_commerce.model.responses.QuantityResponse;
import com.abdullah.e_commerce.network.RetrofitSingleton;
import com.abdullah.e_commerce.network.SharedPref;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowCartProductsAdapter extends RecyclerView.Adapter<ShowCartProductsAdapter.ShowCartProductsViewHolder>{

    Context context;
    List<DataItem> showedData;

    private static final String TAG = "ShowCartProductsAdapter";

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
        double totalPrice = 0;

        for (DataItem item : showedData) {
            totalPrice += Double.parseDouble(item.getProductId().getPriceAfterDiscount());
            Log.i(TAG, "abdo before onBindViewHolder: "+ totalPrice);
        }

        Log.i(TAG, "abdo after onBindViewHolder: "+ totalPrice);

        Picasso.get()
                .load(dataItem.getProductId().getImages().get(0).getImage())
                .placeholder(R.drawable.place_holder_image)
                .into(holder.binding.productAddedToCartItemItemImage);

        holder.binding.productAddedToCartItemItemName.setText(
                dataItem.getProductId().getItemName());

        holder.binding.productAddedToCartItemItemDetails.setText(
                dataItem.getProductId().getDescription());

        holder.binding.productAddedToCartItemItemPrice.setText(
                dataItem.getProductId().getPriceAfterDiscount());

        holder.binding.productAddedToCartItemItemCounterTv.setText(
                dataItem.getQuantity());

        Log.i(TAG, "abdo onBindViewHolder: "+ dataItem.getQuantity());

        String token = SharedPref.read("token", null);

        holder.binding.productAddedToCartItemItemAddIv.setOnClickListener(p->{
            changeQuantity(holder, RetrofitSingleton.connect().addQuantity(
                    dataItem.getProductId().getItemId(), token));
        });

        holder.binding.productAddedToCartItemItemRemoveIv.setOnClickListener(p->{
            changeQuantity(holder, RetrofitSingleton.connect().subQuantity(
                    dataItem.getProductId().getItemId(), token));
        });
    }

    private void changeQuantity(ShowCartProductsViewHolder holder,
                                @NonNull Call<QuantityResponse> modifyQuantity) {
        modifyQuantity.enqueue(new Callback<QuantityResponse>() {
            @Override
            public void onResponse(Call<QuantityResponse> call, Response<QuantityResponse> response) {
                if (response.isSuccessful()){
                    Log.i(TAG, "onResponse: "+ response.body().toString());
                    holder.binding.productAddedToCartItemItemCounterTv.setText(
                            Integer.toString(response.body().getQuantityDetails().getQuantity()));
                }
            }

            @Override
            public void onFailure(Call<QuantityResponse> call, Throwable t) {
                Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
                Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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
