package com.example.system_login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.system_login.R;

public class DaftarPenyakitActivity extends AppCompatActivity {
    TextView hawar;
    TextView blast;
    TextView bercak;
    TextView busuk;
    TextView tungro;
    TextView pelepah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_penyakit);
        hawar = findViewById(R.id.text1);
        blast = findViewById(R.id.text2);
        bercak= findViewById(R.id.text3);
        busuk = findViewById(R.id.text4);
        tungro = findViewById(R.id.text5);
        pelepah = findViewById(R.id.text6);
        hawar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPenyakitActivity.this, PenyakitHawarActivity.class);
                startActivity(intent);
            }
        });
        blast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPenyakitActivity.this, PenyakitBlastActivity.class);
                startActivity(intent);
            }
        });
        bercak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPenyakitActivity.this, PenyakitBercakActivity.class);
                startActivity(intent);
            }
        });
        busuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPenyakitActivity.this, PenyakitBusukBatangActivity.class);
                startActivity(intent);
            }
        });
        tungro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPenyakitActivity.this, PenyakitTungroActivity.class);
                startActivity(intent);
            }
        });
        pelepah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPenyakitActivity.this, PenyakitBusukPelepahActivity.class);
                startActivity(intent);
            }
        });
    }
    }
