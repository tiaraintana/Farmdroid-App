package com.example.system_login.rice_desease_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.system_login.rice_desease_activity.pengendalian.PengendalianHawarActivity;
import com.example.system_login.R;

public class PenyakitHawarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penyakit_hawar);

        }
    public void Kendali(View view){
        Intent intent = new Intent(PenyakitHawarActivity.this, PengendalianHawarActivity.class);
        startActivity(intent);
    }
}
