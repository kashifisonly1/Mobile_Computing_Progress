package com.example.intent_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
    public void goToActivity1(View view) {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void call(View view) {
        Uri uri= Uri.parse("tel:+9209417575");
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);

    }

    public void goToSite(View view) {
        Uri uri= Uri.parse("https://github.com/kashifisonly1/Mobile_Computing_Progress");
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

}