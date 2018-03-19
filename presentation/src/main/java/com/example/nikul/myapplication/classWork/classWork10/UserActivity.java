package com.example.nikul.myapplication.classWork.classWork10;



import android.arch.lifecycle.ViewModelProviders;

import com.example.nikul.myapplication.R;

import com.example.nikul.myapplication.classWork.basepackage.BaseMVVMActivity;
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




}
