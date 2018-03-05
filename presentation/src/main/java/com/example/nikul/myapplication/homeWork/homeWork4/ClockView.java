package com.example.nikul.myapplication.homeWork.homeWork4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;

import com.example.nikul.myapplication.R;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;

/**
 * Created by nikul on 19.02.2018.
 */

public class ClockView extends View {

    private float radius;
    private float cx;
    private float cy;
    private float xLine;
    private float yLine;
    private float yShortLine;
    private float lengthLine;
    private Paint paint;
    private int hour;
    private int minute;
    private int sec;

    public ClockView(Context context) {
        super(context);
        init();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);


    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(h>w){
            radius = w/2.2f;
        } else {
            radius = h/2/2f;
        }
        lengthLine = h/20;
        cx = w/2;
        cy = h/2;
        xLine = cx;
        yLine = cy - radius + lengthLine/2;
        yShortLine = cy -radius +lengthLine/5;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(135,100,241);
        paint.setColor(Color.LTGRAY);
        canvas.drawCircle(cx,cy,radius,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(40f);
        canvas.drawText("12",cx-20,yLine+lengthLine+10,paint);
        canvas.drawText("3",cx+radius-lengthLine-20,cy+10,paint);
        canvas.drawText("6",cx-10,cy+radius-lengthLine,paint);
        canvas.drawText("9",cx-radius+lengthLine,cy+10,paint);
        paint.setStrokeWidth(5f);
        for(int i = 0;i<12;i++) {
            paint.setStrokeWidth(5f);
            canvas.drawLine(xLine, yLine, xLine, yLine - lengthLine, paint);
            canvas.rotate(6, cx, cy);
            paint.setStrokeWidth(2f);
            for(int j = 0;j<4;j++){

                canvas.drawLine(xLine,yShortLine,xLine,yShortLine-lengthLine/3,paint);
                canvas.rotate(6, cx, cy);
            }
        }
        canvas.drawCircle(cx,cy,10,paint);


        GregorianCalendar gc = new GregorianCalendar();
        hour = gc.get(GregorianCalendar.HOUR);
        minute = gc.get(GregorianCalendar.MINUTE);
        sec = gc.get(GregorianCalendar.SECOND);
        canvas.save();
        paint.setStrokeWidth(10f);
        canvas.rotate(30*(hour+(float)minute/60),cx,cy);
        canvas.drawLine(cx,cy,cx,(float)(cy-radius/2.5),paint);
        canvas.restore();
        paint.setStrokeWidth(5f);
        canvas.rotate(6*minute,cx,cy);
        canvas.drawLine(cx,cy,cx,(float)(cy-radius/1.5),paint);
        canvas.restore();
        paint.setStrokeWidth(3f);
        canvas.rotate(6*sec,cx,cy);
        canvas.drawLine(cx,cy,cx,cy-radius/1,paint);
        canvas.restore();
        Log.e("Clock","Drawed");
        invalidate();




    }
}
