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


public class CustomView extends View {

    private Paint paint;
    private RectF rectf;
    private float radius;
    private float cx;
    private float cy;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        radius = w > h ? h/4 : w/4;
        cx = w/2;
        cy = h/2;

        float wRec = w*0.9f;
        float hRec = h*0.2f;

        rectf = new RectF();
        rectf.left = (w-wRec)/2;
        rectf.top = (h-hRec)/2;
        rectf.right = rectf.left+wRec;
        rectf.bottom = rectf.top+hRec;
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
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.GRAY);
        canvas.drawCircle(cx, cy, radius, paint);

        paint.setColor(Color.RED);
        canvas.drawLine(0,0,cx,cy,paint);

       paint.setColor(Color.BLUE);
        canvas.drawRect(rectf,paint);

        canvas.rotate(20,cx,cy);
        paint.setColor(Color.GREEN);
        canvas.drawRect(rectf,paint);

        canvas.rotate(-20,cx,cy);
        canvas.rotate(30);
        paint.setColor(Color.BLACK);
        canvas.drawRect(rectf,paint);

//        invalidate();
//       сохранять и вернуться к исходному положению
//        canvas.save();
//        canvas.restore();






    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN: {
                //проверяет попали ли нажитием в rectange
                rectf.contains(event.getX(),event.getY());

                break;
            }
            case MotionEvent.ACTION_UP: {

                break;
            }
            case MotionEvent.ACTION_MOVE: {
                cx = event.getX();
                cy = event.getY();
                invalidate();
                return false;

            }


        }


        return true;
    }
}
