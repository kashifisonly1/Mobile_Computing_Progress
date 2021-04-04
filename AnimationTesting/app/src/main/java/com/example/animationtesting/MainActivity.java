package com.example.animationtesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void animate(View view) {
        ImageView imageView=findViewById(R.id.imageView);
        imageView.animate().scaleX(2).scaleY(2).rotation(720).setDuration(2000);
    }
}