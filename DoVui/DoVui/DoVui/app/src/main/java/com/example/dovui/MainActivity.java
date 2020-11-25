package com.example.dovui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void batdau(View view) {
        Intent i = new Intent(this,BatDauActivity.class);
        startActivity(i);
    }
    public void huongdan(View view) {
        Intent i = new Intent(this,HuongDanActivity.class);
        startActivity(i);
    }

    public void bangxephang(View view) {
        Intent i = new Intent(this,BangXepHangActivity.class);
        startActivity(i);
    }
    public void caidat(View view) {
        Intent i = new Intent(this,CaiDatActivity.class);
        startActivity(i);
    }
}