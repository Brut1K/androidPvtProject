package com.example.nikul.myapplication.classWork.classWork3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.nikul.myapplication.BuildConfig;
import com.example.nikul.myapplication.R;

/**
 * Created by nikul on 12.02.2018.
 */

public class ClassWork3 extends Activity {

    private Button button3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork3);

        button3 = findViewById(R.id.buttonOne);


    }
}
