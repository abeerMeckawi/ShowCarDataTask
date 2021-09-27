package com.example.showcardatatask.model.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static final String BASE_URL = "http://demo1585915.mockable.io/";

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static APIService getRetrofitService(){
        return retrofit.create(APIService.class);
    }
}
