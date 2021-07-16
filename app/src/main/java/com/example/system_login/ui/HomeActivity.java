package com.example.system_login.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.system_login.R;
import com.google.firebase.auth.FirebaseAuth;

import com.tyagiabhinav.dialogflowchatlibrary.Chatbot;
import com.tyagiabhinav.dialogflowchatlibrary.ChatbotActivity;
import com.tyagiabhinav.dialogflowchatlibrary.ChatbotSettings;
import com.tyagiabhinav.dialogflowchatlibrary.DialogflowCredentials;

import java.util.UUID;

public class HomeActivity extends AppCompatActivity {
    ImageView daftarPenyakit, tentangAplikasi, berita, scanner, catatan, konsultasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        berita = findViewById(R.id.berita);
        catatan =findViewById(R.id.rekap_data);
        daftarPenyakit = findViewById(R.id.dftr_penyakit);
        konsultasi = findViewById(R.id.konsultasi);
        scanner = findViewById(R.id.scanner_padi);
        tentangAplikasi = findViewById(R.id.ttg_program);

        berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                okDialog("Belum Berfungsi :)");
            }
        });

        catatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                okDialog("Belum Berfungsi :)");
            }
        });

        daftarPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDaftarPenyakit();
            }
        });

        konsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatbot();
            }
        });

        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openScanner();
            }
        });

        tentangAplikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });
    }

    private void openDaftarPenyakit() {
        Intent intent = new Intent(HomeActivity.this, DaftarPenyakitActivity.class);
        startActivity(intent);
    }

    private void openAbout() {
        Intent intent = new Intent(HomeActivity.this, AboutAppActivity.class);
        startActivity(intent);
    }

    private void openScanner() {
        Intent intent = new Intent(HomeActivity.this, ScanActivity.class);
        startActivity(intent);
    }

    private void okDialog(String pesan) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pesan");
        builder.setMessage(pesan);
        builder.setCancelable(true);
        builder.setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            finish();
            return true;
        }
        return false;
    }

    private void openChatbot() {
        DialogflowCredentials.getInstance().setInputStream(getResources().openRawResource(R.raw.credential_file));

        ChatbotSettings.getInstance().setChatbot(new Chatbot.ChatbotBuilder().build());

        Bundle bundle = new Bundle();
        bundle.putString(ChatbotActivity.SESSION_ID, UUID.randomUUID().toString());

        Intent intent = new Intent(HomeActivity.this, ChatbotActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
