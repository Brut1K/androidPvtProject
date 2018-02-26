package com.example.nikul.myapplication.homeWork.homeWork5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.nikul.myapplication.R;



public class HomeWork5 extends AppCompatActivity {
    private BroadcastReceiver broadcastReceiver;
    private WifiManager manager;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework5);
        imageView = findViewById(R.id.wifiView);
        manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
            checkwifi();
            }
        };


    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver,new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }

    private void checkwifi(){
        if(manager.isWifiEnabled()){
            imageView.setBackgroundResource(R.drawable.ic_signal_wifi_4_bar_black_24dp);
        } else {
            imageView.setBackgroundResource(R.drawable.ic_signal_wifi_0_bar_black_24dp);
        }
    }
}
