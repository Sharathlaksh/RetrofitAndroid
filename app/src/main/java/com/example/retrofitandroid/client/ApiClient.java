package com.example.retrofitandroid.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.retrofitandroid.constants.AppConstants.BASE_URL;

//----create the Retrofit instance to send the network requests.---//
// use the Retrofit Builder class and specify the base URL for the service.---//
public class ApiClient {
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
