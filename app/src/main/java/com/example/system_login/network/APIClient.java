package com.example.system_login.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl("https://getprediction-3xwvbpl3ka-as.a.run.app").addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
