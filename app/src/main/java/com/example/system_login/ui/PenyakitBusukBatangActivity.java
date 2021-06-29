package com.example.system_login.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.example.system_login.R;

public class PenyakitBusukBatangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penyakit_busukbatang);
        TextView textView = findViewById(R.id.ciri);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
    public void Pindah(View view){
        Intent intent = new Intent(PenyakitBusukBatangActivity.this, PengendalianBusukBatangActivity.class);
        startActivity(intent);
    }
}
