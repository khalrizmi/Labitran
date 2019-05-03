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
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureActivity;

import org.json.JSONException;
import org.json.JSONObject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MenuUtama extends AppCompatActivity implements View.OnClickListener {

    private android.support.v7.widget.Toolbar homeToolbar;
    Context mContext;
    Button mulai;
    ImageButton buttonScan;
    private ZXingScannerView mScannerView;
    IntentIntegrator intentIntegrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        homeToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.HomeToolbar);
        setSupportActionBar(homeToolbar);
        InitViews();

        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, MenuSecond.class));
            }
        });

        buttonScan.setOnClickListener(this);

    }

    private void InitViews(){
        mContext = this;
        mulai = findViewById(R.id.btnMulai);
        buttonScan = findViewById(R.id.btnScan);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_menu,menu);

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem maps = menu.findItem(R.id.map);
        maps.setVisible(true);
        return super.onPrepareOptionsMenu(menu);
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
        else if(id == R.id.map)
        {
            startActivity(new Intent(getApplicationContext(), Maps1.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setPrompt("Scan a barcode");
        intentIntegrator.setCameraId(0);  // Use a specific camera of the device
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setCaptureActivity(CaptureActivityPortrait.class);
        intentIntegrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents() == null){
                Toast.makeText(this, "Hasil tidak ditemukan", Toast.LENGTH_SHORT).show();
            }else{
                // jika qrcode berisi data
                try{
                    // converting the data json
                    JSONObject object = new JSONObject(result.getContents());
                    // atur nilai ke textviews
                    Toast.makeText(mContext, "Hasil : " + object.getString("nama"), Toast.LENGTH_SHORT).show();
                }catch (JSONException e){
                    e.printStackTrace();
                    // jika format encoded tidak sesuai maka hasil
                    // ditampilkan ke toast
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
                    mulai.setVisibility(View.VISIBLE);
                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
