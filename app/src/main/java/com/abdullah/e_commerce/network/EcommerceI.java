package com.abdullah.e_commerce.network;

import com.abdullah.e_commerce.model.reponses.LoginResponse;
import com.abdullah.e_commerce.model.reponses.LogoutResponse;
import com.abdullah.e_commerce.model.reponses.ProductsResponse;
import com.abdullah.e_commerce.model.reponses.RegisterResponse;
import com.abdullah.e_commerce.model.reponses.SearchResponse;
import com.abdullah.e_commerce.model.requests.LoginRequest;
import com.abdullah.e_commerce.model.requests.RegisterRequest;
import com.abdullah.e_commerce.model.requests.SearchRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

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
}
