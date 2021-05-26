package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LoadFragment1(View view) {
        Fragment1 fragment1 = new Fragment1();
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.linearLayout, fragment1);
        transaction.commit();
    }

    public void LoadFragment2(View view) {
        Fragment2 fragment2 = new Fragment2();
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.linearLayout, fragment2);
        transaction.commit();
    }
}