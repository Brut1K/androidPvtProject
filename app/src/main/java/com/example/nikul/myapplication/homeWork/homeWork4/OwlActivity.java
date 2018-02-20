package com.example.nikul.myapplication.homeWork.homeWork4;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.nikul.myapplication.R;

/**
 * Created by nikul on 19.02.2018.
 */

public class OwlActivity extends AppCompatActivity {

    private Button startAnimationButton;
    private ImageView owlImage;
    AnimationDrawable owlAnimaion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owl);
        startAnimationButton = findViewById(R.id.startAnimationOwl);
        owlImage = findViewById(R.id.owlImageView);
        owlImage.setBackgroundResource(R.drawable.sova_animation);
        owlAnimaion = (AnimationDrawable)owlImage.getBackground();
        startAnimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                owlAnimaion.start();
            }
        });

    }


}
