package com.example.system_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PermasalahanPertanian extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permasalahan_pertanian);
        TextView berita1;
        berita1 = findViewById(R.id.berita1);

        berita1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PermasalahanPertanian.this, berita1.class);
                startActivity(intent);
            }
        });

    }
}
