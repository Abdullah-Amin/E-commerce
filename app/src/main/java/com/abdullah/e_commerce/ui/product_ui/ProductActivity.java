package com.abdullah.e_commerce.ui.product_ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.adapters.SliderAdapterExample;
import com.abdullah.e_commerce.model.data_classes.ShowedProductData;
import com.abdullah.e_commerce.model.data_classes.SliderItem;
import com.abdullah.e_commerce.databinding.ActivityProductBinding;
import com.abdullah.e_commerce.model.responses.ShowProductResponse;
import com.abdullah.e_commerce.network.RetrofitSingleton;
import com.abdullah.e_commerce.ui.cart_ui.CartFragment;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

    ActivityProductBinding binding;
    int productId;

    Bundle bundle;

    public ShowedProductData showedProductData;

    private static final String TAG = "ProductActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product);

        productId = getIntent().getIntExtra("productId", 1);

        showFragment(binding.activityProductProductMbtn, new ProductFragment());

        showProduct(productId);

        unPressBtns(binding.activityProductDetailsMbtn, binding.activityProductReviewsMbtn);

        setOnClicks(binding.activityProductProductMbtn, binding.activityProductDetailsMbtn,
                binding.activityProductReviewsMbtn, new ProductFragment());

        setOnClicks(binding.activityProductDetailsMbtn, binding.activityProductProductMbtn,
                binding.activityProductReviewsMbtn, new DetailsFragment());

        setOnClicks(binding.activityProductReviewsMbtn, binding.activityProductDetailsMbtn,
                binding.activityProductProductMbtn, new ReviewsFragment());

        binding.activityProductAddToCartBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, CartFragment.class));
            finish();
        });

        Log.i(TAG, "onCreate: "+ productId);
    }

    private void showProduct(int productId) {

        RetrofitSingleton.connect().showProduct(productId).enqueue(new Callback<ShowProductResponse>() {
            @Override
            public void onResponse(Call<ShowProductResponse> call, Response<ShowProductResponse> response) {
                if (response.isSuccessful()){
                    setDataToUi(response);
                    assert response.body() != null;
//                    setProduct(response.body().getShowedProductData());
                    showedProductData = response.body().getShowedProductData();
//                    bundle = new Bundle();
//                    assert response.body() != null;
//                    bundle.putSerializable("productResponse", response.body().getShowedProductData());
                    Log.i(TAG, "onResponse: "+ response.body().getShowedProductData());
                }
            }

            @Override
            public void onFailure(Call<ShowProductResponse> call, Throwable t) {
                Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
            }
        });
    }

    private void setDataToUi(Response<ShowProductResponse> response) {
        setProductNameAndPrice(response);
        setProductImagesToImageSlider(response);
    }

    private void setProductImagesToImageSlider(Response<ShowProductResponse> response) {
        List<SliderItem> sliderItemsList = new ArrayList<>();

        assert response.body() != null;
        int bounds = response.body().getShowedProductData().getImages().size();

        for (int i = 0; i < bounds; i++) {
            sliderItemsList.add(new SliderItem(response.body().getShowedProductData().getImages().get(i).getProductImage()));
            Log.i(TAG, "setProductImagesToImageSlider: "+ sliderItemsList.get(i));
        }

        binding.activityProductProductImageSlider.setSliderAdapter(
                new SliderAdapterExample(this, sliderItemsList));

    }

    private void setProductNameAndPrice(Response<ShowProductResponse> response) {
        binding.activityProductProductNameTv.setText(
                Objects.requireNonNull(response.body()).getShowedProductData().getItemName());
        Log.i(TAG, "setProductNameAndPrice: "+ response.body().getShowedProductData().getItemName());

        binding.activityProductProductPriceTv.setText(
                Objects.requireNonNull(response.body()).getShowedProductData().getPrice());
        Log.i(TAG, "setProductNameAndPrice: "+ response.body().getShowedProductData().getPrice());
    }

    public void setOnClicks (MaterialButton pressedBtn, MaterialButton firstUnPressedBtn
            , MaterialButton secondUnPressedBtn, Fragment fragment){

        pressedBtn.setOnClickListener(v -> {
            showFragment(pressedBtn, fragment);
            unPressBtns(firstUnPressedBtn, secondUnPressedBtn);
        });
    }

    public void showFragment (MaterialButton highlightedBtn, Fragment fragment){

        highlightedBtn.setBackgroundColor(Color.WHITE);
        highlightedBtn.setTextColor(Color.RED);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.activityProductFrame.getId(), fragment)
                .commit();
    }

    public void unPressBtns ( MaterialButton firstUnPressedBtn, MaterialButton secondUnPressedBtn){
        setBtnGray(firstUnPressedBtn);
        setBtnGray(secondUnPressedBtn);
    }

    public void setBtnGray (MaterialButton btnGray){
        btnGray.setBackgroundColor(Color.TRANSPARENT);
        btnGray.setTextColor(Color.GRAY);
    }

    public ShowedProductData getProduct(){
        return this.showedProductData;
    }

//    public void setProduct(ShowedProductData showedProductData){
//        this.showedProductData = showedProductData;
//    }
}