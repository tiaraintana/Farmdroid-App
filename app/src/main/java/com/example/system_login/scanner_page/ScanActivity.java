package com.example.system_login.scanner_page;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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

import com.example.system_login.ui.DaftarPenyakitActivity;
import com.example.system_login.R;
import com.example.system_login.model.ResponseApi;
import com.example.system_login.network.APIClient;
import com.example.system_login.network.APIService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        if(ContextCompat.checkSelfPermission(ScanActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
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
                    uploadFile();
//                    httpUpload();
                }
                Toast.makeText(ScanActivity.this, "Silahkan Ambil Gambar", Toast.LENGTH_SHORT).show();
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

//    private void httpUpload() {
//        HttpClient httpclient = new DefaultHttpClient();
//        HttpPost httppost = new HttpPost("LINK TO SERVER");
//
//        MultipartEntity mpEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
//        if (filePath != null) {
//            File file = new File(filePath);
//            Log.d("EDIT USER PROFILE", "UPLOAD: file length = " + file.length());
//            Log.d("EDIT USER PROFILE", "UPLOAD: file exist = " + file.exists());
//            mpEntity.addPart("avatar", new FileBody(file, "application/octet"));
//        }
//
//        httppost.setEntity(mpEntity);
//        HttpResponse response = httpclient.execute(httppost);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            try {
                capturedPhoto = (Bitmap) data.getExtras().get("data");
                
                imageView.setImageBitmap(capturedPhoto);
                
                imageUri = getImageUri(getApplicationContext(), capturedPhoto);
                Log.d("IMAGEURI", imageUri.toString());

                imagePath = getPath(imageUri);
//                captureimage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getPath(Uri uri) {
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

    void setLabel(List<String> entries) {
        for (String entry : entries) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ScanActivity.this);
            builder.setMessage("Classified as: " + entry)
                    .setNegativeButton("Retry", null).create().show();
        }
    }

    private void uploadFile() {
        File file = new File(Objects.requireNonNull(imageUri.getPath()));

        RequestBody requestFile = RequestBody.create(MediaType.parse(getContentResolver().getType(imageUri)), file);

        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        APIService getResponse = APIClient.getInstance().create(APIService.class);

        Call<ResponseApi> call = getResponse.upload(body);
        call.enqueue(new Callback<ResponseApi>() {
            @Override
            public void onResponse(Call<ResponseApi> call, Response<ResponseApi> response) {
                ResponseApi apiResponse = response.body();
                Toast.makeText(ScanActivity.this, apiResponse.getPred(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseApi> call, Throwable t) {
                Toast.makeText(ScanActivity.this, "GAGAL :(" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("IMAGEURI", t.getMessage());
            }
        });
    }
}
