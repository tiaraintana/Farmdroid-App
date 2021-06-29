package com.example.system_login.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.system_login.R;

public class SplashscreenActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent homeIntent = new Intent(SplashscreenActivity.this, LoginActivity.class);
                startActivity(homeIntent);
                finish();

            }
        },SPLASH_TIME_OUT);
    }
}
