package com.example.showcardatatask.model.pojos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {

    private int status;
    @SerializedName("data")
    private List<Car> cars;

    public int getStatus() {
        return status;
    }

    public List<Car> getCars() {
        return cars;
    }
}
