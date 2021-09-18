package com.abdullah.e_commerce.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    public static Retrofit retrofit;

    public static EcommerceI connect(){
        if(retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://ecommerce-api.senior-consultingco.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(EcommerceI.class);
    }
}
