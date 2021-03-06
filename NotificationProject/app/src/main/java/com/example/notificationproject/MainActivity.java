package com.example.notificationproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int notificationId = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api= Build.VERSION_CODES.O)
    public void createNotification(View view) {
        String channelId="channel_1";
        CharSequence name = getString(R.string.app_name);
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel notificationChannel=new NotificationChannel(channelId,name,importance);
        Notification notification= new Notification.Builder(MainActivity.this)
                .setContentText("New Message")
                .setContentText("You have new messages")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setChannelId(channelId)
                .setVibrate(new long[]{0,500,1000})
                .setLights(0xFF00FF00, 300, 100)
                .build();
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(notificationChannel);
        notificationManager.notify(notificationId,notification);
    }
}
