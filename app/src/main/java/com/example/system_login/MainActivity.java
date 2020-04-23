package com.example.system_login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    AnimationDrawable animationDrawable;
    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    public void Pindah(View view) {
        String usernameKey = username.getText().toString();
        String passwordKey = password.getText().toString();

        if (usernameKey.equals("") && passwordKey.equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("ISIEN SEK TALAH!!!")
                    .setNegativeButton("Retry", null).create().show();
        }
        else if (usernameKey.equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("ISIEN USERNAME E TAALLLAAHHH!!!")
                    .setNegativeButton("Retry", null).create().show();
        }
        else if(passwordKey.equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("ISIEN PASSWORD E TAALLLAAHHH!")
                    .setNegativeButton("Retry", null).create().show();
        }
        else {
            Intent intent = new Intent(MainActivity.this, MenuAfterLogin.class);
            startActivity(intent);
        }
    }
    public void Registrasi(View view) {
        Intent intent = new Intent(MainActivity.this, RegistrasiActivity.class);
        startActivity(intent);
    }
}


