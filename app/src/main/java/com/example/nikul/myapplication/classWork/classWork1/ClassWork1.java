package com.example.nikul.myapplication.classWork.classWork1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.classWork.classWork2.ClassWork2;

/**
 * Created by nikul on 10.02.2018.
 */

public class ClassWork1 extends Activity implements View.OnClickListener{


    public static String TAG = ClassWork1.class.getSimpleName();
    private Button button1;
    private TextView textView;
    private TextView textView2;
    private String temp;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork1);
        button1 = findViewById(R.id.button1);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(ClassWork1.this, ClassWork2.class);
                intent.putExtra(ClassWork2.KEY_TEXT,"Hello");
                startActivity(intent);

        /*        //эквивалент атрибута noHistory
                finish();

                */


            }
        });


        View.OnClickListener aa = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = (String)textView.getText();
                textView.setText(textView2.getText());
                textView2.setText(temp);
            }
        };
        textView.setOnClickListener(aa);
        textView2.setOnClickListener(this);


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

    @Override
    public void onClick(View v) {
        temp = (String)textView.getText();
        textView.setText(textView2.getText());
        textView2.setText(temp);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
