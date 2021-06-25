package com.example.system_login.rice_desease_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.system_login.rice_desease_activity.pengendalian.PengendalianTungroActivity;
import com.example.system_login.R;

public class PenyakitTungroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penyakit_tungro);
    }
    public void Kendalipindah(View view){
        Intent intent = new Intent(PenyakitTungroActivity.this, PengendalianTungroActivity.class);
        startActivity(intent);
    }
}
