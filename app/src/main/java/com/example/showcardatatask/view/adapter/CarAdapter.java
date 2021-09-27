package com.example.showcardatatask.view.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.showcardatatask.R;
import com.example.showcardatatask.databinding.CarItemRowBinding;
import com.example.showcardatatask.listener.LoadMoreListener;
import com.example.showcardatatask.model.pojos.Car;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarsViewHolder> {


    private List<Car> softCars;
    private final LoadMoreListener loadMoreListener;

    public CarAdapter(LoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
        this.softCars = new ArrayList<>();
    }

    public void setData(List<Car> softCars) {
        this.softCars = softCars;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CarAdapter.CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarsViewHolder(CarItemRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.CarsViewHolder holder, int position) {
        holder.onBindData(softCars.get(position));
        if (position == softCars.size() - 1)
            loadMoreListener.loadMoreListener();
    }

    @Override
    public int getItemCount() {
        return softCars.size();
    }

    public class CarsViewHolder extends RecyclerView.ViewHolder {
        private final CarItemRowBinding carItem;

        public CarsViewHolder(@NonNull CarItemRowBinding carItem) {
            super(carItem.getRoot());
            this.carItem = carItem;
        }

        void onBindData(Car car) {
            Glide.with(carItem.imgCar)
                    .load(car.getImageUrl())
                    .error(R.drawable.no_image)
                    .into(carItem.imgCar);
            carItem.setCar(car);
            carItem.executePendingBindings();
        }
    }
}
