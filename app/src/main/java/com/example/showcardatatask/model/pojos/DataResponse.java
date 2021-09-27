package com.example.showcardatatask.model.pojos;

import java.util.List;

public class DataResponse {

    private int status;
    private List<Car> cars;

    public int getStatus() {
        return status;
    }

    public List<Car> getCars() {
        return cars;
    }
}
