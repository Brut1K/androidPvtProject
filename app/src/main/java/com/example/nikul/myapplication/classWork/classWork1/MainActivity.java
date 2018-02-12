package com.example.nikul.myapplication.classWork.classWork1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.classWork.classWork2.ClassWork2;
import com.example.nikul.myapplication.classWork.classWork2.Singleton;
import com.example.nikul.myapplication.homeWork.homeWork1.HomeWork1;
import com.example.nikul.myapplication.homeWork.homeWork2.HomeWork2;

/**
 * Created by nikul on 05.02.2018.
 */

public class MainActivity extends AppCompatActivity {

    public static String TAG = MainActivity.class.getSimpleName();
    private Button cw1;
    private Button hw1;
    private Button cw2;
    private Button hw2;
    private Button cw3;
    private Button hw3;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cw1 = findViewById(R.id.button1);
        hw1 = findViewById(R.id.button2);
        cw2 = findViewById(R.id.button3);
        hw2 = findViewById(R.id.button4);
        cw3 = findViewById(R.id.button5);
        hw3 = findViewById(R.id.button6);

        cw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ClassWork1.class);
                startActivity(intent);
        /*        //эквивалент атрибута noHistory
                finish();
                */
            }
        });
        hw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeWork1.class);
                startActivity(intent);
            }
        });
        cw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ClassWork2.class);
                intent.putExtra(ClassWork2.KEY_TEXT,"Hello");
                startActivity(intent);
            }
        });
        hw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeWork2.class);
                startActivity(intent);
            }
        });





        Log.e(TAG,"onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }


}