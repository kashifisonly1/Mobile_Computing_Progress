package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LoadDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Dialog Title");
        builder.setMessage("It is message of my Dialog");

        builder.setCancelable(false);
        LayoutInflater inflater=this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog,null));

        builder.setPositiveButton("Positive",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "POSITIVE CLICKED", Toast.LENGTH_LONG).show();
                    }
                }
        );
        builder.setNegativeButton("Negative",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "NEGATIVE CLICKED", Toast.LENGTH_LONG).show();

                    }
                }
        );
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}