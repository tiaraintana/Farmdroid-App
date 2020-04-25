package com.example.system_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HalamanNews extends AppCompatActivity {
    TextView permasalahanPertanian;
    TextView perkembanganTeknologi;
    TextView pemerintah;
    TextView permasalahanHama;
    TextView umum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_news);
        permasalahanPertanian= findViewById(R.id.text1);
        perkembanganTeknologi= findViewById(R.id.text2);
        pemerintah= findViewById(R.id.text3);
        permasalahanHama= findViewById(R.id.text4);
        umum= findViewById(R.id.text5);

        permasalahanPertanian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HalamanNews.this, PermasalahanPertanian.class);
                startActivity(intent);
            }
        });

        perkembanganTeknologi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HalamanNews.this, PerkembanganTeknologi.class);
                startActivity(intent);
            }
        });

        pemerintah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HalamanNews.this, Pemerintah.class);
                startActivity(intent);
            }
        });

        permasalahanHama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HalamanNews.this, PermasalahanHama.class);
                startActivity(intent);
            }
        });

        umum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HalamanNews.this, Umum.class);
                startActivity(intent);
            }
        });
    }
}
