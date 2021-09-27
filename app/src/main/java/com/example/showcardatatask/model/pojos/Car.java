package com.example.showcardatatask.model.pojos;

import com.google.gson.annotations.SerializedName;

public class Car {

    private int id;
    private String brand;
    @SerializedName("constractionYear")
    private String releaseYear;
    private boolean isUsed;
    private String imageUrl;

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
