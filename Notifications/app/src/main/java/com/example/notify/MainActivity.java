package com.example.notify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendnotification(View view) {

        //notification manager
        //notification chanel
        //notificationcompat.builder
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //notification channel
            NotificationChannel nc = new NotificationChannel("srm","NOTIFICATIONS",NotificationManager.IMPORTANCE_HIGH);
            nm.createNotificationChannel(nc);

        }
        //notifications code
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"srm");
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setContentTitle("Notification");
        builder.setContentText(" Hey this is a notification");
        builder.setAutoCancel(true);
        //operation on notify
        //getActivty(), get Service, getBroadcast()
        PendingIntent pi = PendingIntent.getActivity(this,11, new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        /*Jpeg to bitmap
        * make bigpicture sylte b4 issuing the notify*/
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.flower);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));

        nm.notify(42,builder.build());

    }
}