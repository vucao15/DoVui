
package com.example.dovui;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CaiDatActivity extends AppCompatActivity {
    AudioManager audioManager;
    Button btnMute,btnUnmute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai_dat);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        btnMute = findViewById(R.id.button2);
        btnUnmute = findViewById(R.id.button3);
        btnUnmute.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                unmute();
            }
        });
        btnMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mute();
            }
        });


    }
    public void mute() {
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, AudioManager.FLAG_SHOW_UI);

    }
    public void unmute () {
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_UNMUTE, AudioManager.FLAG_SHOW_UI);

    }
}

