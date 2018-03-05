package com.example.nikul.myapplication.homeWork.homeWork3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nikul.myapplication.BuildConfig;
import com.example.nikul.myapplication.R;

/**
 * Created by nikul on 16.02.2018.
 */

public class HomeWork3 extends Activity {

    private String s = "http://bm.img.com.ua/nxs/img/prikol/images/large/0/0/307600.jpg";

    private Button button;
    private EditText editText;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework3);
        button = findViewById(R.id.downloadbutton);
        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.image333);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText(s);

                Glide.with(HomeWork3.this)
                        .load(editText.getText().toString()).into(imageView);

                textView.setText(BuildConfig.API_ENDPOINT);
            }
        });
    }



}
