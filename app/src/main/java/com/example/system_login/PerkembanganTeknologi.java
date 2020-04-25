package com.example.system_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class PerkembanganTeknologi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perkembangan_teknologi);
    }

    public void browserPerkembangan (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?safe=strict&ei=zL2jXvegK9_Wz7sP6L6x6AI&q=berita+perkembangan+teknologi+pertanian&oq=berita+perkembangan+teknologi+pertanian&gs_lcp=CgZwc3ktYWIQAzIICCEQFhAdEB4yCAghEBYQHRAeMggIIRAWEB0QHjIICCEQFhAdEB4yCAghEBYQHRAeMggIIRAWEB0QHjIICCEQFhAdEB4yCAghEBYQHRAeMggIIRAWEB0QHjIICCEQFhAdEB46AggAOgYIABAHEB46BAgAEB46BggAEBYQHjoFCAAQgwE6BAgAEAo6BAgAEBM6CAgAEBYQHhATOgYIABANEB5Q9OMBWMa6AmDDvQJoAHAAeACAAdgBiAG7KpIBBjguMzEuM5gBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwj3tvP234LpAhVf63MBHWhfDC0Q4dUDCAw&uact=5"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }


    public void browserTeknologi1 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pioneer.com/web/site/indonesia/Berita-Umum/Mengenal-Lebih-Jauh-Mengenai-Perkembangan-Teknologi-Pertanian"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }


    public void browserTeknologi2 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.umy.ac.id/sudi/balai-penelitian/perkembangan-teknologi-pertanian/"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }

    public void browserTeknologi3 (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://erakini.com/teknologi-pertanian/"));
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW.Url.parse("http://www.google.com"));
        startActivity(browserIntent);
    }




}
