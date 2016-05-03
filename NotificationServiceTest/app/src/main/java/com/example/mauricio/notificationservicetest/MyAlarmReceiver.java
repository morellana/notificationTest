package com.example.mauricio.notificationservicetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by mauricio on 27-04-16.
 */
public class MyAlarmReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MyTestService", "onReceive on MyAlarmReceiver");
//        Toast.makeText(context, "mensaje de prueba: " + intent.getAction().toString() , Toast.LENGTH_SHORT).show();

        Intent i = new Intent(context, ExampleService.class);
        context.startService(i);
    }
}