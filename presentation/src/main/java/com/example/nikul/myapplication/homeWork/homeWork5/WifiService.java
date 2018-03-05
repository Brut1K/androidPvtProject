package com.example.nikul.myapplication.homeWork.homeWork5;

import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


public class WifiService extends Service {
    WifiManager manager;

    private final String LOG = "WifiService";
    private final IBinder mBinder = new LocalBinder();

    @Override
    public void onCreate() {
        Log.e(LOG,"onCreate");
        manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(LOG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(LOG,"onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(LOG,"onUbbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.e(LOG,"onRebind");
        super.onRebind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(LOG,"onBind");
        return mBinder;
    }

    public void changeWifi(){
        if(manager.isWifiEnabled()) {
            manager.setWifiEnabled(false);
        } else {
            manager.setWifiEnabled(true);
        }
    }

    public class LocalBinder extends Binder{
        WifiService getService(){
            return WifiService.this;
        }
    }
}
