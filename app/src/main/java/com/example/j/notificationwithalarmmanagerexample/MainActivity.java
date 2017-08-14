package com.example.j.notificationwithalarmmanagerexample;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Context context = this;

        switch (item.getItemId()) {
            case R.id.action_5:
                NotificationUtils.scheduleNotification(context, "Scheduled Notification 1", "5 second delay", 5000);
                return true;
            case R.id.action_10:
                NotificationUtils.scheduleNotification(context, "Scheduled Notification 2", "10 second delay", 10000);
                return true;
            case R.id.action_30:
                NotificationUtils.scheduleNotification(context, "Scheduled Notification 3", "30 second delay", 30000);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
