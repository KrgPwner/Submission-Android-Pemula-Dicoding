package com.example.submissionbelajarmembuataplikasiandroidpemulamaldiariqi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailSUVActivity extends AppCompatActivity {

    private TextView Nama;
    private TextView Peringkat;
    private TextView Informasi;
    private ImageView Foto;

    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_INFO = "extra_info";
    public static final String EXTRA_FOTO = "extra_foto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_suv);
        getSupportActionBar().setTitle("Detail Page");

        DeklarasiView();

        DeskripsiView();
    }

    private void DeklarasiView(){
        this.Nama = findViewById(R.id.nama_detail);
        this.Informasi = findViewById(R.id.informasi_detail);
        this.Foto = findViewById(R.id.foto_detail);
    }

    private void DeskripsiView(){
        this.Nama.setText(getIntent().getStringExtra(EXTRA_NAMA));
        this.Informasi.setText(getIntent().getStringExtra(EXTRA_INFO));
        Glide.with(DetailSUVActivity.this).load(getIntent().getStringExtra(EXTRA_FOTO)).apply(new RequestOptions()).into(Foto);
    }
}
