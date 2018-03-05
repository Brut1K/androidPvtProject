package com.example.nikul.myapplication.homeWork.homeWork1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nikul.myapplication.R;


/**
 * Created by nikul on 10.02.2018.
 */

public class HomeWork1 extends Activity implements View.OnClickListener{

    private Button button1;
    private TextView textView;
    private TextView textView2;
    private String temp;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework1);
        button1 = findViewById(R.id.button1);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = (String)textView.getText();
                textView.setText(textView2.getText());
                textView2.setText(temp);
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

    }



    @Override
    public void onClick(View v) {
        temp = (String)textView.getText();
        textView.setText(textView2.getText());
        textView2.setText(temp);
    }
}
