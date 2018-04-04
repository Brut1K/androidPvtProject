package com.example.nikul.myapplication.presentation.screens.user;



import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.example.nikul.myapplication.R;

import com.example.nikul.myapplication.presentation.base.BaseMVVMActivity;
import com.example.nikul.myapplication.databinding.ActivityClasswork10Binding;


public class UserActivity extends BaseMVVMActivity<ActivityClasswork10Binding, UserViewModel> {

    //закинуть в screens/user

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.recyclerviewCW10.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerviewCW10.setHasFixedSize(true);
        binding.recyclerviewCW10.setAdapter(viewModel.userAdapter);
        
    }
}
