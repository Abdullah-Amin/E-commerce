package com.abdullah.e_commerce.ui.product_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.adapters.AutoImageSliderAdapter;
import com.abdullah.e_commerce.model.data_classes.ShowedProductData;
import com.abdullah.e_commerce.model.data_classes.SliderItem;
import com.abdullah.e_commerce.databinding.ActivityProductBinding;
import com.abdullah.e_commerce.model.requests.AddToCartRequest;
import com.abdullah.e_commerce.model.responses.AddToCartResponse;
import com.abdullah.e_commerce.model.responses.ShowProductResponse;
import com.abdullah.e_commerce.network.RetrofitSingleton;
import com.abdullah.e_commerce.network.SharedPref;
import com.abdullah.e_commerce.ui.main_ui.HomeActivity;
import com.google.android.material.button.MaterialButton;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

    ActivityProductBinding binding;
    int productId;
    private ShowedProductData showedProductData;

    private String color;
    private String size;

    ProductFragment productFragment = new ProductFragment();
    DetailsFragment detailsFragment = new DetailsFragment();
    ReviewsFragment reviewsFragment = new ReviewsFragment();

    Bundle bundle;

    private static final String TAG = "ProductActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product);

        productId = getIntent().getIntExtra("productId", 1);

        if(productId < 1)return;

        showProduct(productId);

//        productFragment.setArguments(bundle);
//        showFragment(binding.activityProductProductMbtn, productFragment);


        unPressBtns(binding.activityProductDetailsMbtn, binding.activityProductReviewsMbtn);


        setOnClicks(binding.activityProductProductMbtn, binding.activityProductDetailsMbtn,
                binding.activityProductReviewsMbtn, productFragment);
        Log.i(TAG, "onCreate: bundle "+ bundle);

        detailsFragment.setArguments(bundle);
        setOnClicks(binding.activityProductDetailsMbtn, binding.activityProductProductMbtn,
                binding.activityProductReviewsMbtn, new DetailsFragment());

        reviewsFragment.setArguments(bundle);
        setOnClicks(binding.activityProductReviewsMbtn, binding.activityProductDetailsMbtn,
                binding.activityProductProductMbtn, new ReviewsFragment());

        String token = SharedPref.read(SharedPref.Token, null);

        binding.activityProductAddToCartBtn.setOnClickListener(v -> {
            RetrofitSingleton.connect().addToCart(token,
                    new AddToCartRequest(showedProductData.getItemId(), getColor(), getSize()))
            .enqueue(new Callback<AddToCartResponse>() {
                @Override
                public void onResponse(Call<AddToCartResponse> call, Response<AddToCartResponse> response) {
                    if (response.isSuccessful()){
                        Log.i(TAG, "abdo onResponse: ---- "+ response.body().getAddedToCartProductData());
                    }
                }

                @Override
                public void onFailure(Call<AddToCartResponse> call, Throwable t) {
                    Log.i(TAG, "abdo onFailure: ---- "+ t.getLocalizedMessage());
                }
            });
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("productActivity", ProductActivity.TAG);
            startActivity(intent);
//            finish();
        });


        Log.i(TAG, "onCreate: "+ productId);
    }

    private void showProduct(int productId) {

        RetrofitSingleton.connect().showProduct(productId).enqueue(new Callback<ShowProductResponse>() {
            @Override
            public void onResponse(@NonNull Call<ShowProductResponse> call, @NonNull Response<ShowProductResponse> response) {
                if (response.isSuccessful()){
                    setDataToUi(response);
                    assert response.body() != null;
//                    setProduct(response.body().getShowedProductData());
                    showedProductData = response.body().getShowedProductData();
                    Bundle productBundle = new Bundle();
                    productBundle.putSerializable("showedProductData", response.body().getShowedProductData());
                    productBundle.putSerializable("productResponse", response.body().getShowedProductData());

                    Log.i(TAG, "onResponse: "+ response.body().getShowedProductData());
                }
                else{
                    Log.i(TAG, "onResponse: failure");
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
            Log.i(TAG, "setProductImagesToImageSlider: "+ sliderItemsList.get(i).getProductImage());
        }

        binding.activityProductProductImageSlider.setSliderAdapter(
                new AutoImageSliderAdapter(this, sliderItemsList));

        binding.activityProductProductImageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        binding.activityProductProductImageSlider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        binding.activityProductProductImageSlider.startAutoCycle();
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

    public ShowedProductData getProductData(){
        Log.i(TAG, "getProductData: "+ showedProductData);
        return showedProductData;
    }

    public void setProductColor(String color){
        Log.i(TAG, "abdo setProductColor: "+ color);
        this.color = color;
    }

    public void setProductSize(String size){
        Log.i(TAG, "abdo setProductSize: "+ size);
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }
}