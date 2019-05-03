package com.mlabitran.m_labitran;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PreviewKasus extends AppCompatActivity {

    private android.support.v7.widget.Toolbar homeToolbar;
    Context mContext;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_kasus);
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

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, MenuSecond.class));
            }
        });
    }

    private void InitViews(){
        buttonNext = findViewById(R.id.btnNext);
        mContext = this;
    }
}
