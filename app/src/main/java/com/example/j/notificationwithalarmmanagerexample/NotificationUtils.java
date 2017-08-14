package com.example.j.notificationwithalarmmanagerexample;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.NotificationCompat;

/**
 * Created by J on 10/08/2017.
 */

public class NotificationUtils {
    public static void scheduleNotification(Context context, String title, String content, int delay) {

        int id_of_notification = 1;

        Notification notification = generateNotification(context, title, content);

        Intent notificationIntent = new Intent(context, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, id_of_notification);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;

        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);

        // To cancel an alarm - pass the pending intent to cancel
        //alarmManager.cancel(pendingIntent);
    }

    public static Notification generateNotification(Context context, String title, String content) {

        Intent intent = new Intent(context, NotificationClickActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, 0,intent,0);

        return new NotificationCompat.Builder(context)
            .setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
            .build();
    }
}
