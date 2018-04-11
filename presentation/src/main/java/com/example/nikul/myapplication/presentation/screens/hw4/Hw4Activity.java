package com.example.nikul.myapplication.presentation.screens.hw4;


import android.arch.lifecycle.ViewModelProviders;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.databinding.ActivityHomework4Binding;
import com.example.nikul.myapplication.presentation.base.BaseMVVMActivity;

public class Hw4Activity extends BaseMVVMActivity<ActivityHomework4Binding,Hw4ViewModel> {
    @Override
    public int provideLayoutId() {
        return R.layout.activity_homework4;
    }

    @Override
    public Hw4ViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(Hw4ViewModel.class);
    }
}
