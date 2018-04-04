package com.example.data.entity;


import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id")
    private String id;
    @SerializedName("images")
    private Images images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }


    @Override
    public String toString() {
        return "Data{" +
                "id ='" + id + '\'' +
                ", url = " + images.getOriginal().getUrl() +
                '}';
    }
}
