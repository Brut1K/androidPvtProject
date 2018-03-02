package com.example.nikul.myapplication.samples.broadcact;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nikul.myapplication.R;



public class BroadcastActivity extends AppCompatActivity {


    final String LOG_TAG = "myLogs";

    final int TASK1_CODE = 1;
    final int TASK2_CODE = 2;
    final int TASK3_CODE = 3;

    public final static int STATUS_START = 100;
    public final static int STATUS_FINISH = 200;

    public final static String PARAM_TIME = "time";
    public final static String PARAM_TASK = "task";
    public final static String PARAM_RESULT = "result";
    public final static String PARAM_STATUS = "status";

    public final static String BROADCAST_ACTION = "com.example.nikul.myapplication.samples";

    TextView tvTask1;
    TextView tvTask2;
    TextView tvTask3;
    Button btnStart;
    BroadcastReceiver br;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        tvTask1 = findViewById(R.id.tvTask1);
        tvTask1.setText("Task1");
        tvTask2 = findViewById(R.id.tvTask2);
        tvTask2.setText("Task2");
        tvTask3 = findViewById(R.id.tvTask3);
        tvTask3.setText("Task3");
        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(LOG_TAG,"Click");
                Intent intent;

                Log.e(LOG_TAG,"Start first Service");
                // Создаем Intent для вызова сервиса,
                // кладем туда параметр времени и код задачи
                intent = new Intent(BroadcastActivity.this, MyServiceActivity.class)
                        .putExtra(PARAM_TIME, 20)
                        .putExtra(PARAM_TASK, TASK1_CODE);
                // стартуем сервис
                startService(intent);

                Log.e(LOG_TAG,"Start second Service");


                intent = new Intent(BroadcastActivity.this, MyServiceActivity.class)
                        .putExtra(PARAM_TIME, 10)
                        .putExtra(PARAM_TASK, TASK2_CODE);
                startService(intent);

                Log.e(LOG_TAG,"Start third Service");
                intent = new Intent(BroadcastActivity.this, MyServiceActivity.class)
                        .putExtra(PARAM_TIME, 5)
                        .putExtra(PARAM_TASK, TASK3_CODE);
                startService(intent);
            }
        });

        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int task = intent.getIntExtra(PARAM_TASK,0);
                int status = intent.getIntExtra(PARAM_STATUS,0);
                Log.e(LOG_TAG,"onReceive: task = " + task + ", status = " + status);

                if(status == STATUS_START){
                    switch (task){
                        case TASK1_CODE:{
                            tvTask1.setText("Task1 start");
                            break;
                        }
                        case TASK2_CODE:{
                            tvTask2.setText("Task2 start");
                            break;
                        }
                        case TASK3_CODE:{
                            tvTask3.setText("Task3 start");
                            break;
                        }
                    }
                }
                if(status == STATUS_FINISH){
                    int result = intent.getIntExtra(PARAM_RESULT,0);
                    switch (task){
                        case TASK1_CODE:{
                            tvTask1.setText("Task1 finish, result = " + result );
                            break;
                        }
                        case TASK2_CODE:{
                            tvTask2.setText("Task2 finish, result = " + result);
                            break;
                        }
                        case TASK3_CODE:{
                            tvTask3.setText("Task3 finish, result = " + result);
                            break;
                        }
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(BROADCAST_ACTION);
        registerReceiver(br,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(br);
    }

//    public void onClickStart(View v) {
//        Intent intent;
//
//        // Создаем Intent для вызова сервиса,
//        // кладем туда параметр времени и код задачи
//        intent = new Intent(this, MyServiceActivity.class).putExtra(PARAM_TIME, 7)
//                .putExtra(PARAM_TASK, TASK1_CODE);
//        // стартуем сервис
//        startService(intent);
//
//        intent = new Intent(this, MyServiceActivity.class).putExtra(PARAM_TIME, 4)
//                .putExtra(PARAM_TASK, TASK2_CODE);
//        startService(intent);
//
//        intent = new Intent(this, MyServiceActivity.class).putExtra(PARAM_TIME, 6)
//                .putExtra(PARAM_TASK, TASK3_CODE);
//        startService(intent);
//    }
}
