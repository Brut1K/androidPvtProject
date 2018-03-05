package com.example.nikul.myapplication.classWork.classWork5;


import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {

    public static final String KEY_LINK = "KEY_LINK";

    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        Log.e("MyIntentService","onCreate");
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e("IntentService","IntentService");
        Log.e("IntentService",intent.getStringExtra(KEY_LINK));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void onDestroy() {
        Log.e("IntentService","onDestroy");
        super.onDestroy();
    }
}
