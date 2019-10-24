package com.example.submissionbelajarmembuataplikasiandroidpemulamaldiariqi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvSUV;
    private ArrayList<SUV> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Main Page");

        rvSUV = findViewById(R.id.rv_suv);
        rvSUV.setHasFixedSize(true);

        list.addAll(SUVData.getListData());
        showRecyclerList();

    }

    private void showRecyclerList(){
        rvSUV.setLayoutManager(new LinearLayoutManager(this));
        ListSUVAdapter listSUVAdapter = new ListSUVAdapter(list);
        rvSUV.setAdapter(listSUVAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuabout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.About:
                Intent about = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(about);
                break;
        }
    }


}
