package com.example.mirea_5.ui.hello_fragment;

import android.Manifest;
import android.app.NotificationChannel;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationManager {

    private final static String CHANNEL_ID = "channel_id";
    private final int notificationId = 1;

    NotificationChannel importantChannel = new NotificationChannel("channel_id!", "Важные уведомления!", android.app.NotificationManager.IMPORTANCE_DEFAULT);

    NotificationCompat.Builder builder;

    NotificationManagerCompat notificationManager;

    public NotificationManager(Context context) {
        builder = new NotificationCompat.Builder(context, importantChannel.getId());
        notificationManager = NotificationManagerCompat.from(context);
        notificationManager.createNotificationChannel(importantChannel);
    }

    public void sendNotification(String title, String text, int drawable, Context context) {

        if (!checkPermission(context)) {
            Toast.makeText(context, "NOT OK", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show();

        constructNotification(title, text, drawable);

        notificationManager.notify(
                notificationId, builder.build()
        );
    }

    private boolean checkPermission(Context context) {
        return ActivityCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED;
    }

    private void constructNotification(String title, String text, int drawable) {
        builder.setSmallIcon(drawable)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }

}