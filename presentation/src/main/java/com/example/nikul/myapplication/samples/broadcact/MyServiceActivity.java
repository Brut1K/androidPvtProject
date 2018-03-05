package com.example.nikul.myapplication.samples.broadcact;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyServiceActivity extends Service {

    final String LOG_TAG = "myLogs";
    ExecutorService es;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(LOG_TAG,"MyService onCreate");
        es = Executors.newFixedThreadPool(2);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(LOG_TAG,"MyService onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(LOG_TAG,"MyService onStartCommand, task " + intent.getIntExtra(BroadcastActivity.PARAM_TASK,0));
        int time = intent.getIntExtra(BroadcastActivity.PARAM_TIME,1);
        int task = intent.getIntExtra(BroadcastActivity.PARAM_TASK,0);
        MyRun mr = new MyRun(startId, time, task);
        es.execute(mr);

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class MyRun implements Runnable{

        int time;
        int startId;
        int task;

        public MyRun(int startId, int time, int task) {
            this.time = time;
            this.startId = startId;
            this.task = task;
            Log.e(LOG_TAG,"MyRun#" + startId + " create");
        }

        @Override
        public void run() {
            Intent intent = new Intent(BroadcastActivity.BROADCAST_ACTION);
            Log.e(LOG_TAG,"MyRun " + startId + " start, time " + time);
            try {
                // сообщаем о старте задачи
                intent.putExtra(BroadcastActivity.PARAM_TASK, task);
                intent.putExtra(BroadcastActivity.PARAM_STATUS, BroadcastActivity.STATUS_START);
                sendBroadcast(intent);

                // начинаем выполнение задачи
                TimeUnit.SECONDS.sleep(time);

                // сообщаем об окончании задачи
                intent.putExtra(BroadcastActivity.PARAM_STATUS, BroadcastActivity.STATUS_FINISH);
                intent.putExtra(BroadcastActivity.PARAM_RESULT, time * 100);
                sendBroadcast(intent);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop();
        }

        void stop() {
            Log.e(LOG_TAG, "MyRun#" + startId + " end, stopSelfResult("
                    + startId + ") = " + stopSelfResult(startId));
        }
    }
}
