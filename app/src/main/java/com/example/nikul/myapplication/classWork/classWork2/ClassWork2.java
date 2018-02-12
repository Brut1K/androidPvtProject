package com.example.nikul.myapplication.classWork.classWork2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.classWork.classWork1.MainActivity;

/**
 * Created by nikul on 09.02.2018.
 */

public class ClassWork2 extends AppCompatActivity {
    public static final String KEY_TEXT = "KEY_TEXT";
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork2);
        String text = getIntent().getStringExtra("KEY_TEXT");
        button = findViewById(R.id.button1);
        if(text.contains("Hello")){
            Log.e("AAA","contain");
        } else {
            Log.e("AAA","not contain");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                onBackPressed();
            }
        });
    }
}
