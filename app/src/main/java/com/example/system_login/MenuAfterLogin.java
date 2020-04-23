package com.example.system_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuAfterLogin extends AppCompatActivity {
    ImageView Daftar, TtgProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_after_login);

        Daftar = findViewById(R.id.dftr_penyakit);
        TtgProgram = findViewById(R.id.ttg_program);

        Daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAfterLogin.this, TentangPenyakit.class);
                startActivity(intent);
            }
        });

        TtgProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAfterLogin.this, TentangAplikasi.class);
                startActivity(intent);
            }
        });
    }
}
