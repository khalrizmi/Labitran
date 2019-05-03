package com.mlabitran.m_labitran;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TahapanKunjungan extends AppCompatActivity {

    private android.support.v7.widget.Toolbar homeToolbar;
    ImageView ambilgambar, gambarObject;
    Button buttonUpload;
    Context mContext;
    TextView textgambar;

    private static final int CAMERA_REQUEST_CODE = 7777;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahapan_kunjungan);
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

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, MenuSecond.class));
            }
        });

        ambilgambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST_CODE);
            }
        });
    }


    private void InitViews(){
        ambilgambar = findViewById(R.id.take_picture);
        gambarObject = findViewById(R.id.image_object);
        buttonUpload = findViewById(R.id.btnUpload);
        textgambar = findViewById(R.id.tv_take);
        mContext = this;
    }


    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case(CAMERA_REQUEST_CODE):
                if (resultCode == Activity.RESULT_OK)
                {
                    Bitmap bitmap;
                    bitmap = (Bitmap)data.getExtras().get("data");
                    gambarObject.setVisibility(View.VISIBLE);
                    ambilgambar.setVisibility(View.GONE);
                    textgambar.setVisibility(View.GONE);
                    gambarObject.setImageBitmap(bitmap);
                }
                break;
        }
    }
}
