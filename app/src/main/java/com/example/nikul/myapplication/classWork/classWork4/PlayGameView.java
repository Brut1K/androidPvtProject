package com.example.nikul.myapplication.classWork.classWork4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by nikul on 16.02.2018.
 */

public class PlayGameView extends View {
    private Paint paint;
    private RectF rectF1;
    private RectF rectF2;
    private RectF rectF3;
    private RectF rectF4;
    private float cx1;
    private float cy1;
    private float cx2;
    private float cy2;
    private float cx3;
    private float cy3;

    public PlayGameView(Context context) {
        super(context);
        init();
    }

    public PlayGameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PlayGameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PlayGameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cx1 = w/4;
        cy1 = h/4;

        float hRec = h/4;
        float wRec = w/4;
        rectF1 = new RectF(cx1-wRec,cy1-hRec,cx1+wRec,cy1+hRec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.rotate(0,cx1,cy1);
        paint.setColor(Color.BLACK);
        canvas.drawRect(rectF1,paint);
        canvas.rotate(90,cx1,cy1);
        paint.setColor(Color.BLUE);
        canvas.drawRect(rectF1,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(MotionEvent.ACTION_MOVE==event.getAction()){
            cx1 = event.getX();
            cy1 = event.getY();
            invalidate();
            return false;

        }


        return true;
    }
}


