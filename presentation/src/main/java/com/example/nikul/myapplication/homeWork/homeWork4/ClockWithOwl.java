package com.example.nikul.myapplication.homeWork.homeWork4;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.nikul.myapplication.R;

/**
 * Created by nikul on 20.02.2018.
 */

public class ClockWithOwl extends FrameLayout {

    private ClockView clockView;
    private ImageView imageView;
    AnimationDrawable animationDrawable;


    public ClockWithOwl(@NonNull Context context) {
        super(context);
        init();
    }

    public ClockWithOwl(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClockWithOwl(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClockWithOwl(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(){
        clockView = new ClockView(getContext());
        imageView = new ImageView(getContext());
        imageView.setBackgroundResource(R.drawable.sova_animation);
        animationDrawable = (AnimationDrawable)imageView.getBackground();
        addView(clockView);
        addView(imageView);

    }


}
