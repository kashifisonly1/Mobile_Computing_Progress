package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ((ImageView)findViewById(R.id.mainImageView)).setImageResource(getIntent().getIntExtra("img", 0));
        ((TextView)findViewById(R.id.title)).setText(getIntent().getStringExtra("name"));
        ((TextView)findViewById(R.id.description)).setText(getIntent().getStringExtra("description"));

    }
}