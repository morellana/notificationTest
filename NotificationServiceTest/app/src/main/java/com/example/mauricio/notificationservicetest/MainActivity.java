package com.example.mauricio.notificationservicetest;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showLocalNotification(View view) {
        Log.i("MyTestService", "showLocalNotification");

        Intent notificationIntent = new Intent(getBaseContext(), ResultActivity.class);
        PendingIntent intent = PendingIntent.getActivity(getBaseContext(), 0, notificationIntent, 0);

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setTicker("New notification")
                        .setContentTitle("My notification")
                        .setContentText("Hello World!")
                        .setContentIntent(intent);

        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(1, mBuilder.build());
    }

    public void setAlarm(View view) {
        Log.i("MyTestService", "Test");

        int interval = 2; // minutes

        Intent receiverIntent = new Intent(getBaseContext(), MyAlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(getBaseContext(), 123456789, receiverIntent, 0);

        AlarmManager alarmManager = (AlarmManager)getBaseContext().getSystemService(Context.ALARM_SERVICE);
        if (alarmManager == null) Log.i("MyTestService", "alarmManager es null");

        // tipo alarma, primer lanzamiento, intervalo lanzamientos, Intent a ejecutar
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime()+interval*60*1000, interval*60*1000, sender);
        Log.i("MyTestService", "End Test");
    }

}
