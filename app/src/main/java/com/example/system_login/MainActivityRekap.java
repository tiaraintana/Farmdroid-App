package com.example.system_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityRekap extends AppCompatActivity {

    private Button btCreateDB;
    private Button btViewDB;
    private Button btnPetunjuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rekap);

        btCreateDB = (Button) findViewById(R.id.bt_createdata);
        btViewDB = (Button) findViewById(R.id.bt_viewdata);
        btnPetunjuk =(Button) findViewById(R.id.bt_PetunjukPenggunaan);


        btnPetunjuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                startActivity(FirebaseDBCreateActivity.getActIntent(MainActivityRekap.this));
                Intent intent = new Intent(MainActivityRekap.this, PetunjukFiturRekapData.class);
                startActivity(intent);

            }
        });
        btCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                startActivity(FirebaseDBCreateActivity.getActIntent(MainActivityRekap.this));
                Intent intent = new Intent(MainActivityRekap.this, FirebaseDBCreateActivity.class);
                startActivity(intent);

            }
        });

        btViewDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(FirebaseDBReadActivity.getActIntent(MainActivityRekap.this));

                Intent intent = new Intent(MainActivityRekap.this, FirebaseDBReadActivity.class);
                startActivity(intent);
            }
        });
    }
}
