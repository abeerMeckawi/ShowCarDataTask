package com.example.showcardatatask.model.network;
import com.example.showcardatatask.model.pojos.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("api/v1/cars")
    Call<DataResponse> getCars(@Query("page") int page);
}
