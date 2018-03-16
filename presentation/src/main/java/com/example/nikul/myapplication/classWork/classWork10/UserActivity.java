package com.example.nikul.myapplication.classWork.classWork10;



import com.example.nikul.myapplication.R;

import com.example.nikul.myapplication.classWork.basepackage.BaseMVVMActivity;
import com.example.nikul.myapplication.databinding.ActivityClasswork10Binding;


public class UserActivity extends BaseMVVMActivity<ActivityClasswork10Binding, UserViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_classwork10;
    }

    @Override
    public UserViewModel provideViewModel() {
        return new UserViewModel();
    }


}
