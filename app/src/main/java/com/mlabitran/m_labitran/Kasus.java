package com.mlabitran.m_labitran;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Kasus extends AppCompatActivity {

    private android.support.v7.widget.Toolbar homeToolbar;
    ImageButton jkasus;
    Context mContext;
    TextView textViewkasus,textgambar;
    Button buttonUpload;
    ImageView ambilgambar, gambarObject;
    private static final int CAMERA_REQUEST_CODE = 7777;

    protected ArrayList<Integer> pilihkasus;
    protected CharSequence[] kasusmu = {"Fitting","Flooringe","DoorCloser"};
    boolean[] pilihankasusmu = new boolean[kasusmu.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kasus);
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
        AlertJenisKasus();

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
        jkasus = findViewById(R.id.btnjeniskasus);
        textViewkasus = findViewById(R.id.tvkasus);
        mContext = this;
        buttonUpload = findViewById(R.id.btnUpload);
        ambilgambar = findViewById(R.id.take_picture);
        gambarObject = findViewById(R.id.image_object);
        textgambar = findViewById(R.id.tv_take);

    }

    private void AlertJenisKasus(){
        jkasus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pilihkasus = new ArrayList<Integer>();
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Pilih Jenis Kasus")
                        .setMultiChoiceItems(kasusmu, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                pilihankasusmu[which] = isChecked;
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String dataPilih = "";

                                for(int i=0; i < kasusmu.length; i++){
                                    if (pilihankasusmu[i]){
                                        dataPilih += kasusmu[i] + ",";
                                        pilihankasusmu[i] = false;
                                    }
                                }

                                textViewkasus.setText(dataPilih);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }
        });
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
