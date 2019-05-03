package com.mlabitran.m_labitran;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class UserLogin extends AppCompatActivity {

    Context mContext;
    Button buttonlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        InitViews();

    }

    private void InitViews(){
        buttonlogin = findViewById(R.id.btnLogin);
        mContext = this;

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, Maps1.class));
            }
        });
    }
}
