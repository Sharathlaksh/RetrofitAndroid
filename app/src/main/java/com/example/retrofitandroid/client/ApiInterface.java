package com.example.retrofitandroid.client;

import com.example.retrofitandroid.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("photos")
    Call<List<Album>> getAlbum();
}
