package com.example.system_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Umum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umum);
    }

    public void browserUmum(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=berita+umum&oq=berita+umum&aqs=chrome..69i57j0l6j69i60.4348j0j4&sourceid=chrome&ie=UTF-8"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }


    public void browserUmum1 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(" https://otomotif.kompas.com/read/2020/04/24/065200315/larangan-mudik-berlaku-hari-ini-pergerakan-kendaraan-bakal-dibatasi"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }


    public void browserUmum2 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.liputan6.com/ramadan/read/4237149/wajah-muslim-di-dunia-hadapi-ramadan-di-tengah-pandemi-covid-19?medium=Headline&campaign=Headline_click_1"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }

    public void browserUmum3 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://news.detik.com/berita-jawa-barat/d-4990770/jaga-ketat-exit-tol-cileunyi-polisi-halau-mobil-pemudik?tag_from=wp_hl_img"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }



}
