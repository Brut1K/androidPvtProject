package com.example.nikul.myapplication.homeWork.homeWork9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.databinding.ActivityHomework9Binding;


public class HomeWork9 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User user = new User("Alex","30",true,"https://pp.userapi.com/c10611/u14788377/-6/y_7fdf5e4c.jpg");
        User user2 = new User("Zhenya","27",false,"https://pp.userapi.com/c624417/v624417365/2dcca/EmwIh8ZtfBo.jpg");
        User[] users  = {user,user2};



        ActivityHomework9Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_homework9);
        binding.setMyUser(users[(int)(Math.random()*2)]);
    }
}
