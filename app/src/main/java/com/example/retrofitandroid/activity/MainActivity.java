package com.example.retrofitandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.retrofitandroid.R;
import com.example.retrofitandroid.adapters.RecyclerAdapter;
import com.example.retrofitandroid.client.ApiClient;
import com.example.retrofitandroid.client.ApiInterface;
import com.example.retrofitandroid.model.Album;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Album> mAlbumList;
    RecyclerView mRecyclerView;
    RecyclerAdapter mRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init ui elements
        init();
        getAlbumList();
    }

    public void init() {
        mAlbumList = new ArrayList<>();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerAdapter = new RecyclerAdapter(getApplicationContext(), mAlbumList);
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    public void getAlbumList() {
        //----TO consume the REST web service. In Our MainActivity.Java, First,initialize the ApiClient.---//
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        //-----call the getAlbum() interface and implement the CallBacks.-----//
        Call<List<Album>> call = apiService.getAlbum();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                mAlbumList = response.body();
                Log.d("TAG", "Response = " + mAlbumList);
                //setting response to adapter
                mRecyclerAdapter.setAlbumList(mAlbumList);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }
}
