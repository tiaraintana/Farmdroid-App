package com.example.system_login.api.service;

import android.database.Observable;

import com.example.system_login.api.model.ResponseApi;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    @Multipart
    @POST(".")
    Call<ResponseApi> uploadImage(@Part MultipartBody.Part file);
}
