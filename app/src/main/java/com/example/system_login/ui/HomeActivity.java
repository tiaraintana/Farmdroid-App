package com.example.system_login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.system_login.R;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    ImageView daftarPenyakit, tentangAplikasi, berita, scanner, catatan, konsultasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        berita = findViewById(R.id.berita);
        catatan =findViewById(R.id.rekap_data);
        daftarPenyakit = findViewById(R.id.dftr_penyakit);
        konsultasi = findViewById(R.id.konsultasi);
        scanner = findViewById(R.id.scanner_padi);
        tentangAplikasi = findViewById(R.id.ttg_program);

        berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miniToast();
            }
        });

        catatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miniToast();
            }
        });

        daftarPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DaftarPenyakitActivity.class);
                startActivity(intent);
            }
        });

        konsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miniToast();
            }
        });

        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ScanActivity.class);
                startActivity(intent);
            }
        });

        tentangAplikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutAppActivity.class);
                startActivity(intent);
            }
        });
    }

    private void miniToast() {
        Toast t = Toast.makeText(HomeActivity.this, "Belum Berfungsi :)", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            finish();
            return true;
        }
        return false;
    }
}
