package com.abdullah.e_commerce.network;

import com.abdullah.e_commerce.model.responses.LatestProductResponse;
import com.abdullah.e_commerce.model.responses.LoginResponse;
import com.abdullah.e_commerce.model.responses.LogoutResponse;
import com.abdullah.e_commerce.model.responses.ProductsResponse;
import com.abdullah.e_commerce.model.responses.RegisterResponse;
import com.abdullah.e_commerce.model.responses.ResetPasswordResponse;
import com.abdullah.e_commerce.model.responses.SearchResponse;
import com.abdullah.e_commerce.model.requests.LoginRequest;
import com.abdullah.e_commerce.model.requests.RegisterRequest;
import com.abdullah.e_commerce.model.requests.ResetPasswordRequest;
import com.abdullah.e_commerce.model.requests.SearchRequest;
import com.abdullah.e_commerce.model.responses.ShowProductResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EcommerceI {

    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @POST("logout")
    Call<LogoutResponse> logout(@Header("Authorization") String token);

    @POST("register")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @POST("search")
    Call<SearchResponse> search(@Body SearchRequest searchRequest);

    @GET("products")
    Call<ProductsResponse> getProducts();

    @GET("latest-product")
    Call<LatestProductResponse> getLatestProducts();

    @GET("show-product/{productId}")
    Call<ShowProductResponse> showProduct(@Path("productId") String productId);

    @POST("password/reset")
    Call<ResetPasswordResponse> resetPassword(@Body ResetPasswordRequest resetPasswordRequest,
                                              @Header("Authorization") String token);
}
