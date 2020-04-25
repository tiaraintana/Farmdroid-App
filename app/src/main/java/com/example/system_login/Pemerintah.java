package com.example.system_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Pemerintah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemerintah);
    }

    public void browserPemerintahan (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?safe=strict&ei=xbyjXpDLA8iw9QPOqLeoAg&q=berita+pemerintahan&oq=berita+pemerintahan&gs_lcp=CgZwc3ktYWIQAzICCAAyAggAMgIIADICCAAyAggAMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjoECAAQEzoICAAQFhAeEBM6BQgAEIMBUNyUAVjeuwFgqr4BaABwAHgAgAGaAYgBqhiSAQQyLjI1mAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwjQwZf53oLpAhVIWH0KHU7UDSUQ4dUDCAw&uact=5"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }


    public void browserPemerintahan1 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://kominfo.go.id/content/all/berita"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }


    public void browserPemerintahan2 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://news.detik.com/berita/d-4985343/update-kasus-corona-di-ri-7135-positif-842-sembuh-dan-616-meninggal?_ga=2.244558466.622574263.1587788454-755293541.1571637219"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }

    public void browserPemerintahan3 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://money.kompas.com/read/2020/04/25/061200426/soal-penanganan-covid-19-di-indonesia-ini-kata-susi-pudjiastuti"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }




}
