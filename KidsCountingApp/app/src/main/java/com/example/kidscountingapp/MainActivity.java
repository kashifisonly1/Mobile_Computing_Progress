package com.example.kidscountingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer= MediaPlayer.create(this,R.raw.bg);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    public void startApp(View view) {
        Intent intent= new Intent(this, PlayCounting.class);
        startActivity(intent);
    }
}