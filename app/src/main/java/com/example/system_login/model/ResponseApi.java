package com.example.system_login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseApi {

    @SerializedName("prediction")
    @Expose
    private String pred;

    public String getPred() {
        return pred;
    }

    public void setPred(String pred) {
        this.pred = pred;
    }
}
