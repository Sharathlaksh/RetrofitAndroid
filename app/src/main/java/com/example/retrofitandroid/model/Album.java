package com.example.retrofitandroid.model;

import com.google.gson.annotations.SerializedName;


public class Album {
    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    @SerializedName("thumbnailUrl")
    private String imageThumbnail;
    @SerializedName("title")
    private String imageTitle;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @SerializedName("id")
    private String imageId;


}
