package com.example.system_login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.system_login.helper.TFLiteHelper;

import java.util.List;

public class ScanActivity extends AppCompatActivity {

    ImageView imageView;
    Button btOpen, detect, daftar_penyakit;

    TFLiteHelper tfLiteHelper;
    Bitmap captureimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        imageView = findViewById(R.id.image_view);
        btOpen = findViewById(R.id.bt_open);
        detect = findViewById(R.id.detect);
        daftar_penyakit = findViewById(R.id.daftar_penyakit);

        tfLiteHelper = new TFLiteHelper(this);
        tfLiteHelper.init();

        if(ContextCompat.checkSelfPermission(ScanActivity.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(ScanActivity.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    }, 100);
        }
        daftar_penyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScanActivity.this, TentangPenyakit.class);
                startActivity(intent);
            }
        });
        detect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (captureimage != null) {
                    tfLiteHelper.classifyImage(captureimage);
                    setLabel(tfLiteHelper.showresult());
                }
            }
        });
        btOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            try {
                captureimage = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(captureimage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void setLabel(List<String> entries) {
        for (String entry : entries) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ScanActivity.this);
            builder.setMessage("Classified as: " + entry)
                    .setNegativeButton("Retry", null).create().show();
        }
    }
}
