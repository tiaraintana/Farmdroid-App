package com.example.system_login.network;

import com.example.system_login.model.ResponseApi;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APIService {
    @POST(".")
    @Multipart
    Call<ResponseApi> upload(@Part MultipartBody.Part file);
}
