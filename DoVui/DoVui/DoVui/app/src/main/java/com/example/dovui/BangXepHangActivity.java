package com.example.dovui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BangXepHangActivity extends AppCompatActivity {
ListView lv;
List<Player> list;
    PlayerAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_xep_hang);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

        lv = findViewById(R.id.lvXepHang);
        list = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            Player player = new Player();
            player.setName("Player"+i);
            player.setPoint(i*10);
            list.add(player);
        }
adapter = new PlayerAdapter(list,this);
        lv.setAdapter(adapter);

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}