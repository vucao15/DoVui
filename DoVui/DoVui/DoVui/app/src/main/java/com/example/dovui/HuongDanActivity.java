package com.example.dovui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HuongDanActivity extends AppCompatActivity {
Button button;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huong_dan);
        button = findViewById(R.id.btnnext2);
        textView = findViewById(R.id.txtHuongDan);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}