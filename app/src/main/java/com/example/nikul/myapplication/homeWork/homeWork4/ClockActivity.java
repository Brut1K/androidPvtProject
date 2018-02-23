package com.example.nikul.myapplication.homeWork.homeWork4;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.nikul.myapplication.R;

/**
 * Created by nikul on 19.02.2018.
 */

public class ClockActivity extends AppCompatActivity {

    private ImageView owlInClock;
    private AnimationDrawable animationDrawable;
    private ClockView clockView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        clockView = findViewById(R.id.clockView);
        owlInClock = findViewById(R.id.owlInClock);
        animationDrawable = (AnimationDrawable) owlInClock.getBackground();
        animationDrawable.start();

    }
}
