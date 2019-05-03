package com.mlabitran.m_labitran;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TugasComplete extends AppCompatActivity {

    private android.support.v7.widget.Toolbar homeToolbar;
    Button buttonCompleted;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas_complete);
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
        buttonCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Data Tersimpan...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(mContext, UserLogin.class));
            }
        });
    }

    private void InitViews(){
        buttonCompleted = findViewById(R.id.btnCompleted);
        mContext = this;
    }
}
