package com.mlabitran.m_labitran;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HasilPekerjaan extends AppCompatActivity {

    private android.support.v7.widget.Toolbar homeToolbar;
    Button buttonTambah, buttonSelesai;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_pekerjaan);
        homeToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.HomeToolbar);
        homeToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        homeToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setSupportActionBar(homeToolbar);


        InitViews();
        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, MenuSecond.class));
            }
        });

        buttonSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, Maps1.class));
            }
        });
    }

    private void InitViews(){
        buttonTambah = findViewById(R.id.btnTambah);
        buttonSelesai = findViewById(R.id.btnSelesai);
        mContext = this;
    }
}
