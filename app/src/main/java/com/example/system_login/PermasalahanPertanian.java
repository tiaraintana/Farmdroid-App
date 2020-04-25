package com.example.system_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PermasalahanPertanian extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permasalahan_pertanian);
//        TextView berita1;
//        berita1 = findViewById(R.id.berita1);
//
//        berita1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(PermasalahanPertanian.this, berita1.class);
//                startActivity(intent);
//            }
//        });

    }

    public void browser1 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }


    public void browserBerita1 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.agrofarm.co.id/2020/03/22000/"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }


    public void browserBerita2 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://industri.kontan.co.id/news/hkti-tantangan-pertanian-saat-ini-adalah-masalah-ketersediaan-lahan?page=all"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }

    public void browserBerita3 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://katadata.co.id/berita/2020/04/22/kementan-evaluasi-anomali-lonjakan-harga-beras-dan-ayam"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }




}
