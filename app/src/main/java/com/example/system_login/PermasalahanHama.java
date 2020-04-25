package com.example.system_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class PermasalahanHama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permasalahan_hama);
    }


    public void browserHama (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=berita+permasalahan+hama&oq=berita+permasalahan+hama&aqs=chrome..69i57.5840j0j4&sourceid=chrome&ie=UTF-8"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }


    public void browserHama1 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kompas.com/tag/serangan-hama"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }


    public void browserHama2 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://radarjombang.jawapos.com/read/2020/03/29/186115/hama-wereng-menyerang-dewan-minta-dinas-pertanian-lebih-proaktif"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }

    public void browserHama3 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wartaekonomi.co.id/read247136/kementan-perkenalkan-cara-jitu-basmi-siput-murbai-aman-dan-alami"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }



}
