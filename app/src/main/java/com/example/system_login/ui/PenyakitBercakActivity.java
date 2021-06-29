package com.example.system_login.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.system_login.R;

public class PenyakitBercakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penyakit_bercak);
    }
    public void Kendali(View view){
        Intent intent = new Intent(PenyakitBercakActivity.this, PengendalianBercakActivity.class);
        startActivity(intent);
    }
}
