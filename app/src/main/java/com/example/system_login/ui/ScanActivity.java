package com.example.system_login.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.system_login.R;
import com.example.system_login.api.model.ResponseApi;
import com.example.system_login.api.service.ApiClient;
import com.example.system_login.api.service.ApiService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@SuppressWarnings("deprecation")
public class ScanActivity extends AppCompatActivity {

    ImageView imageView;
    Button btOpen, detect, daftar_penyakit;

    Bitmap capturedPhoto;
    Uri imageUri;
    String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        imageView = findViewById(R.id.image_view);
        btOpen = findViewById(R.id.bt_open);
        detect = findViewById(R.id.detect);
        daftar_penyakit = findViewById(R.id.daftar_penyakit);

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
                    //TODO: MASUKKAN KODINGAN API GCP DISINI
                    uploadFile2();
//                    httpUpload();
                } else {
                    Toast.makeText(ScanActivity.this, "Silahkan Ambil Gambar", Toast.LENGTH_SHORT).show();
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
                capturedPhoto = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(capturedPhoto);
                imageUri = getImageUri(getApplicationContext(), capturedPhoto);
                imagePath = getImagePath(imageUri);
//                captureimage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getImagePath(Uri uri) {
        String[] projection = {MediaStore.MediaColumns.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();

        return cursor.getString(column_index);
    }

    private Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

//    void setLabel(List<String> entries) {
//        for (String entry : entries) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(ScanActivity.this);
//            builder.setMessage("Classified as: " + entry)
//                    .setNegativeButton("Retry", null).create().show();
//        }
//    }

    private void uploadFile() {
        File file = new File(Objects.requireNonNull(imagePath));
        Retrofit retrofit = ApiClient.getRetrofit();
        RequestBody requestBody = RequestBody.create(MediaType.parse(getContentResolver().getType(imageUri)), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ResponseApi> call = apiService.uploadImage(body);
        call.enqueue(new Callback<ResponseApi>() {
            @Override
            public void onResponse(Call<ResponseApi> call, Response<ResponseApi> response) {
                ResponseApi apiResponse = response.body();
                Toast.makeText(ScanActivity.this, apiResponse.getPred(), Toast.LENGTH_SHORT).show();
                Log.d("IMAGEURI", apiResponse.getPred());
            }

            @Override
            public void onFailure(Call<ResponseApi> call, Throwable t) {
                Toast.makeText(ScanActivity.this, "GAGAL :(\n" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("IMAGEURI", t.getMessage());
            }
        });
    }

    private void uploadFile2() {
        File file = new File(imagePath);

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form/data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        Retrofit retrofit = ApiClient.getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);

        Call<ResponseApi> call = apiService.uploadImage(body);
        call.enqueue(new Callback<ResponseApi>() {
            @Override
            public void onResponse(Call<ResponseApi> call, Response<ResponseApi> response) {
                ResponseApi apiResponse = response.body();
                Toast.makeText(ScanActivity.this, apiResponse.getPred(), Toast.LENGTH_SHORT).show();
                Log.d("IMAGEURI", apiResponse.getPred());
            }

            @Override
            public void onFailure(Call<ResponseApi> call, Throwable t) {
                Toast.makeText(ScanActivity.this, "GAGAL :(\n" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("IMAGEURI", t.getMessage());
            }
        });
    }
}
