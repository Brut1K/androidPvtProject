package com.example.nikul.myapplication.presentation.screens.hw5;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.app.App;
import com.example.nikul.myapplication.presentation.base.BaseViewModel;

import javax.inject.Inject;

public class Hw5ViewModel extends BaseViewModel {
    public WifiManager manager;
    public ImageView imageView;
    private BroadcastReceiver broadcastReceiver;
    private WifiService mService;
    private boolean mBound = false;

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    @Inject
    public Context context;

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public ObservableField<String> textView = new ObservableField<>("");
    public ObservableField<String> button = new ObservableField<>("");

    public Hw5ViewModel() {
        manager = (WifiManager) context
                .getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                checkwifi();
            }
        };
    }






    public void onClick(View view){
        Log.e("CLICK","CLICK");
        if(manager.isWifiEnabled()) {
            Log.e("IF TRUE","");
            manager.setWifiEnabled(false);
            checkwifi();
        } else {
            Log.e("ELSE","");
            manager.setWifiEnabled(true);
            checkwifi();
        }
    }


    public void checkwifi(){
        if(manager.isWifiEnabled()){
            imageView.setBackgroundResource(R.drawable.ic_signal_wifi_4_bar_black_24dp);
            textView.set("Wifi ON");
            button.set("Выключить wifi");
            Log.e("checkWIFI","ON");

        } else {
            imageView.setBackgroundResource(R.drawable.ic_signal_wifi_0_bar_black_24dp);
            textView.set("Wifi OFF");
            button.set("Включить wifi");
            Log.e("checkWIFI","OF");
        }

    }
}
