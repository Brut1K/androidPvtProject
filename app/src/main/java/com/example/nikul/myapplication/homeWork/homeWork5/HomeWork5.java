package com.example.nikul.myapplication.homeWork.homeWork5;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikul.myapplication.R;



public class HomeWork5 extends AppCompatActivity {

    private final String LOG = "HomeWork5 Activity";

    private BroadcastReceiver broadcastReceiver;
    private ServiceConnection serviceConnection;
    private WifiManager manager;
    private ImageView imageView;
    private TextView textView;
    private WifiService mService;
    private boolean mBound = false;
    Button button;
    Intent intent;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e(LOG,"onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework5);
        imageView = findViewById(R.id.wifiView);
        textView = findViewById(R.id.textViewWifi);
        button = findViewById(R.id.buttonWifi);

        manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
            checkwifi();
            }
        };




        intent = new Intent(HomeWork5.this,WifiService.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mService.changeWifi();
                checkwifi();
            }
        });

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.e(LOG,"onServiceConnected");
                WifiService.LocalBinder binder = (WifiService.LocalBinder) service;
                mService = binder.getService();
                mBound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.e(LOG,"onServiceDisconnected");
                mBound = false;
            }
        };
    }

    @Override
    protected void onResume() {
        Log.e(LOG,"onResume");
        super.onResume();
        IntentFilter intentFilter = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(broadcastReceiver,intentFilter);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
        mBound = true;

    }

    @Override
    protected void onStop() {
        Log.e(LOG,"onStop");
        super.onStop();
        unregisterReceiver(broadcastReceiver);
        unbindService(serviceConnection);
        mBound = false;
    }

    private void checkwifi(){
        if(manager.isWifiEnabled()){
            imageView.setBackgroundResource(R.drawable.ic_signal_wifi_4_bar_black_24dp);
            textView.setText("Wifi ON");
            button.setText("Выключить wifi");

        } else {
            imageView.setBackgroundResource(R.drawable.ic_signal_wifi_0_bar_black_24dp);
            textView.setText("Wifi OFF");
            button.setText("Включить wifi");
        }

    }



}
