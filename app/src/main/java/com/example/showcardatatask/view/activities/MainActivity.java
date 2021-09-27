package com.example.showcardatatask.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.os.Bundle;

import com.example.showcardatatask.R;
import com.example.showcardatatask.databinding.ActivityMainBinding;
import com.example.showcardatatask.viewmodel.CarsViewModel;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private CarsViewModel carsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        carsViewModel = new ViewModelProvider(this).get(CarsViewModel.class);


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
    }
}