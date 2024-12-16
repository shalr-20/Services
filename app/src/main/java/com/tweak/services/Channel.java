package com.tweak.services;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Channel extends Application {  //application is a subclass of the Context
    public static final String ChannelId="MyChannel";

    @Override
    public void onCreate() {
        super.onCreate();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){  //to check if the version i'm currently working on is greater than the version of Oreo (O)

            //create a channel for the notification
            NotificationChannel servChan=new NotificationChannel(
                    ChannelId, "service", NotificationManager.IMPORTANCE_DEFAULT  //id, name,priority
            );

            //starting the notification channel
            NotificationManager manager=getSystemService(NotificationManager.class);  //to get the NotificationManager class (created)
            manager.createNotificationChannel(servChan);

        }
    }


}