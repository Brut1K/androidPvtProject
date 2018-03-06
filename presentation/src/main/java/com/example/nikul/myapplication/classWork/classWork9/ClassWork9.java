package com.example.nikul.myapplication.classWork.classWork9;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.databinding.ActivityClasswork9Binding;

public class ClassWork9 extends AppCompatActivity {
    private static final String TAG = ClassWork9.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_classwork9);
        MyEntity myEntity = new MyEntity("Ура работает","Супер кнопка");
        ActivityClasswork9Binding binding =
            DataBindingUtil.setContentView(this,R.layout.activity_classwork9);
        binding.setMyEntity(myEntity);
    }
}
