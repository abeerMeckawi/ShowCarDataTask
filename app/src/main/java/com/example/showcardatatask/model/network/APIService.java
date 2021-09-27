package com.example.showcardatatask.model.network;

import com.example.showcardatatask.model.pojos.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("/api/v1/cars")
    Call<List<Car>> getCars(@Query("page") int page);
}
