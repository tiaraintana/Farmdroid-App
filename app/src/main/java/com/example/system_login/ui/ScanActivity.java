package com.example.system_login.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.example.system_login.R;

import java.io.ByteArrayOutputStream;

@SuppressWarnings("deprecation")
public class ScanActivity extends AppCompatActivity {

    private ImageView imageView;

    private Bitmap capturedPhoto;
    private String base64;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(ScanActivity.this));
        }

        Python py = Python.getInstance();
        final PyObject pyObj = py.getModule("script");

        imageView = findViewById(R.id.image_view);
        Button daftar_penyakit = findViewById(R.id.daftar_penyakit);
        Button detect = findViewById(R.id.detect);
        Button openCamera = findViewById(R.id.bt_open);

        //Izin Kamera
        if (ContextCompat.checkSelfPermission(ScanActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ScanActivity.this, new String[]{
                    Manifest.permission.CAMERA
            }, 100);
        }

        daftar_penyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScanActivity.this, DaftarPenyakitActivity.class);
                startActivity(intent);
            }
        });

        detect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (capturedPhoto != null) {
                    base64 = imageBitmapToBase64(capturedPhoto);
                    PyObject obj = pyObj.callAttr("main", base64);
                    Toast.makeText(ScanActivity.this, obj.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ScanActivity.this, "Silahkan Ambil Gambar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        openCamera.setOnClickListener(new View.OnClickListener() {
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
                capturedPhoto = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(capturedPhoto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String imageBitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }
}
