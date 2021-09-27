package com.example.showcardatatask.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.showcardatatask.model.network.APIClient;
import com.example.showcardatatask.model.pojos.Car;
import com.example.showcardatatask.model.pojos.DataResponse;
import com.example.showcardatatask.model.pojos.DataStatus;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarsViewModel extends ViewModel {

    private final List<Car> carList = new ArrayList<>();
    public MutableLiveData<List<Car>> cars = new MutableLiveData<>();
    public MutableLiveData<DataStatus> dataStatus = new MutableLiveData<>();
    private int page = 1;

    public CarsViewModel(){getCars();}

    private void getCars() {
        if(page == -1) return;
        dataStatus.setValue(DataStatus.LOADING);
        APIClient.getRetrofitService().getCars(page).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.body() !=null && response.body().getStatus() == 1 && response.body().getCars().size() !=0){
                    carList.addAll(response.body().getCars());
                    cars.setValue(carList);
                    page++;
                }else {
                    page = -1;
                }

                dataStatus.setValue(DataStatus.DONE);
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                dataStatus.setValue(DataStatus.FAIL);
            }
        });

    }
}
