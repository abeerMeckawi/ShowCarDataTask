package com.example.showcardatatask.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.example.showcardatatask.R;
import com.example.showcardatatask.databinding.ActivityMainBinding;
import com.example.showcardatatask.listener.LoadMoreListener;
import com.example.showcardatatask.view.adapter.CarAdapter;
import com.example.showcardatatask.viewmodel.CarsViewModel;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements LoadMoreListener {

    private ActivityMainBinding activityMainBinding;
    private CarsViewModel carsViewModel;
    private CarAdapter carAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        carAdapter = new CarAdapter(this);
        activityMainBinding.recycler.setAdapter(carAdapter);

        carsViewModel = new ViewModelProvider(this).get(CarsViewModel.class);

        carsViewModel.cars.observe(this, cars -> carAdapter.setData(cars));

        carsViewModel.dataStatus.observe(this,dataStatus -> {
            switch (dataStatus){
                case LOADING:
                   activityMainBinding.setIsLoading(true);break;
                case DONE:
                    activityMainBinding.setIsLoading(false);break;
                case FAIL:
                    activityMainBinding.setIsLoading(false);
                    Snackbar.make(activityMainBinding.getRoot(),"Network Error",Snackbar.LENGTH_SHORT).show();
                    break;
            }
        });

        activityMainBinding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                carsViewModel.getCars();
                activityMainBinding.swipeRefresh.setRefreshing(false);
            }
        });
    }

    @Override
    public void loadMoreListener() {
        carsViewModel.getCars();
    }
}