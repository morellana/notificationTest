package com.example.mauricio.notificationservicetest;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by mauricio on 27-04-16.
 */
public class ExampleService extends IntentService{

    public ExampleService() {
        super("MyTestService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Do the task here
        Log.i("MyTestService", "Service running");
//        Toast.makeText(getBaseContext(), "mensaje desde ExampleService", Toast.LENGTH_SHORT).show();

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setTicker("New notification")
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");

        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(1, mBuilder.build());

/*
        mNotificationManager.notify(1, mBuilder.build());
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),
                        "mensaje desde ExampleService",
                        Toast.LENGTH_SHORT).show();
            }
        });
*/
    }
}
