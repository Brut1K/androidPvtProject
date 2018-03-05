package com.example.nikul.myapplication.classWork.classWork5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.nikul.myapplication.R;


public class ClassWork5 extends AppCompatActivity {
    private Button button;
    private LocalBroadcastManager localBroadcastManager;
    private static final String ACTION_MY_MESSAGE="com.example.nikul.myapplication.classWork.classWork5";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork5);
        button = findViewById(R.id.cw5button);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(ACTION_MY_MESSAGE);
                localBroadcastManager.sendBroadcast(intent);
           //     sendBroadcast(intent);
            }
        });

    }


    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean isAirPlaneModeOn = intent.getBooleanExtra("state",false);
            Log.e("AAA","MY ACTION CATHED");
            if(isAirPlaneModeOn) {
                Log.e("AAA", "MESSAGE From Activity ON");
            } else {
                Log.e("AAA", "Message from Activity off");
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_MY_MESSAGE);
        localBroadcastManager.registerReceiver(myReceiver,intentFilter);
    //    registerReceiver(myReceiver,intentFilter);

        Intent intent = new Intent(this,MyService.class);
        startService(intent);

//        Intent intent1 = new Intent(this,MyIntentService.class);
//        intent1.putExtra(MyIntentService.KEY_LINK,"http://file1");
//        startService(intent1);
//
//        Intent intent2 = new Intent(this,MyIntentService.class);
//        intent2.putExtra(MyIntentService.KEY_LINK,"http://file2");
//        startService(intent2);
//
//
//        Intent intent3 = new Intent(this,MyIntentService.class);
//        intent3.putExtra(MyIntentService.KEY_LINK,"http://file3");
//        startService(intent3);


    }

    @Override
    protected void onStop() {
        super.onStop();
        localBroadcastManager.unregisterReceiver(myReceiver);

        stopService(new Intent(this,MyService.class));

     //   unregisterReceiver(myReceiver);
    }
}
