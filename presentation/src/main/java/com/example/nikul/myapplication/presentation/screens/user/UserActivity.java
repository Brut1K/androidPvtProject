package com.example.nikul.myapplication.presentation.screens.user;



import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.example.nikul.myapplication.R;

import com.example.nikul.myapplication.presentation.base.BaseMVVMActivity;
import com.example.nikul.myapplication.databinding.ActivityClasswork10Binding;
import com.example.nikul.myapplication.presentation.base.BaseMVVMActivitywithRouter;
import com.example.nikul.myapplication.presentation.base.Router;


public class UserActivity extends BaseMVVMActivitywithRouter<ActivityClasswork10Binding, UserViewModel,UserRouter> {

    //закинуть в screens/user
    private static final String KEY_USER_ID ="KEY_USER_ID";

    public static void show(Activity activity, String id){
        Intent intent = new Intent(activity,UserActivity.class);
        intent.putExtra(KEY_USER_ID,id);
        activity.startActivity(intent);
    }

    @Override
    public int provideLayoutId() {
        return R.layout.activity_classwork10;
    }

    @Override
    public UserViewModel provideViewModel() {
        //такое создание класса привязывает к экземпляру жизненный цикл
        // и при дестрое активиту вызовется метод onCleared у UserViewModel
        return ViewModelProviders.of(this).get(UserViewModel.class);
    }

    @Override
    public UserRouter provideRouter() {
        return new UserRouter(this);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.recyclerviewCW10.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerviewCW10.setHasFixedSize(true);
        binding.recyclerviewCW10.setAdapter(viewModel.userAdapter);
        
    }
}
