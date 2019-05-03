package com.mlabitran.m_labitran;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    TextView judul;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        InitViews();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ConnectivityManager CM = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = CM.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected()){
                    Intent o = new Intent(getApplicationContext(),UserLogin.class);
                    o.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    o.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(o);
                }else{
                    startActivity(new Intent(getApplicationContext(),NoConnection.class));
                    Intent p = new Intent(getApplicationContext(),NoConnection.class);
                    p.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    p.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(p);
                }
            }
        }, 3000);

    }

    private void InitViews(){
        judul = findViewById(R.id.txjudul);
        mContext = this;
    }
}
