package com.example.system_login.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.example.system_login.R;

public class PenyakitBlastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penyakit_blast);
        TextView textView = findViewById(R.id.ciri2);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
    public void Kendali(View view){
        Intent intent = new Intent(PenyakitBlastActivity.this, PengendalianBlastActivity.class);
        startActivity(intent);
    }
}
