//to use notification as a bg service (notification will be shown even after closing the app / the notification won't disappear when the app is closed)
package com.tweak.services;

import static com.tweak.services.Channel.ChannelId;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class Services extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //whenever you have to trigger any notification, you have to start the service in bg
    public int onStartCommand(Intent intent, int flags, int startId){  //will be called when the service is started
        Intent notiIntent=new Intent(this,MainActivity.class);
        PendingIntent penIntent=PendingIntent.getActivity(this,0, notiIntent,PendingIntent.FLAG_IMMUTABLE);

        //building the notification
        Notification noti=new NotificationCompat.Builder(this, ChannelId)
                .setContentTitle("My notification")
                .setContentText("This is my notification")
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentIntent(penIntent).build();

        //starting service in bg
        startForeground(1, noti);

        // Service will not restart if killed
        return START_NOT_STICKY;  //to control what happens if the system kills the service due to low memory
    }

    @Override
    public void onCreate(){  //will be created at once
        super.onCreate();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

}