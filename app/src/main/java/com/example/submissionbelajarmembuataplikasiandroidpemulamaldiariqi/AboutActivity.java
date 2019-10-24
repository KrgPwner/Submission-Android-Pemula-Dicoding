package com.example.submissionbelajarmembuataplikasiandroidpemulamaldiariqi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class AboutActivity extends AppCompatActivity {

    private ImageView Foto;
    private TextView Nama;
    private TextView Email;

    private String StrFoto = "https://www.dicoding.com/images/small/avatar/20170923220254f305c67d493215e698e3c31b29398803.jpg";
    private String StrNama = "Muhammad Aldi Ariqi";
    private String StrEmail = "aldi48767@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setTitle("About Page");

        DeklarasiView();

        DeskripsiView();
    }

    private void DeklarasiView(){
        this.Foto = findViewById(R.id.foto_about);
        this.Nama = findViewById(R.id.nama_about);
        this.Email = findViewById(R.id.email_about);
    }

    private void DeskripsiView(){
        Glide.with(AboutActivity.this).load(StrFoto).apply(new RequestOptions()).into(Foto);
        this.Nama.setText(this.StrNama);
        this.Email.setText(this.StrEmail);
    }
}
