package com.example.nikul.myapplication.homeWork.homeWork4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.nikul.myapplication.R;

/**
 * Created by nikul on 19.02.2018.
 */

public class HomeWork4 extends AppCompatActivity {

    private Button owlButton;
    private Button clockButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4);
        owlButton = findViewById(R.id.owlButton);
        clockButton = findViewById(R.id.clockButton);
        owlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeWork4.this,OwlActivity.class);
                startActivity(intent);
                setAnimation();
            }
        });
        clockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeWork4.this,ClockActivity.class);
                startActivity(intent);
                setAnimation();
            }
        });
    }

    public void setAnimation(){
        overridePendingTransition(R.anim.animation_zoom_out,R.anim.animation_zoom_in);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setAnimation();
    }
}


