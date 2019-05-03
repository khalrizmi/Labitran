package com.mlabitran.m_labitran;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Maps1 extends AppCompatActivity {

    private android.support.v7.widget.Toolbar homeToolbar;
    Button buttonSelanjutnya;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        homeToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.HomeToolbar);
        setSupportActionBar(homeToolbar);

        InitViews();
        buttonSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, MenuUtama.class));
            }
        });
    }

    private void InitViews(){
        mContext = this;
        buttonSelanjutnya = findViewById(R.id.btnNext);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_profile)
        {
            Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.action_pengaturan)
        {
            Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.action_help)
        {
            startActivity(new Intent(mContext, Help.class));
        }
        else if(id == R.id.action_logout)
        {
            startActivity(new Intent(getApplicationContext(), UserLogin.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
