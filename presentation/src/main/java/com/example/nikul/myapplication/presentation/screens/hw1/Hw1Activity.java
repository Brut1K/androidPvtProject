package com.example.nikul.myapplication.presentation.screens.hw1;

import android.arch.lifecycle.ViewModelProviders;

import com.example.nikul.myapplication.R;

import com.example.nikul.myapplication.databinding.ActivityHomework1Binding;
import com.example.nikul.myapplication.presentation.base.BaseMVVMActivity;
import com.example.nikul.myapplication.presentation.base.BaseViewModel;

public class Hw1Activity extends BaseMVVMActivity<ActivityHomework1Binding,Hw1ViewModel>{
    @Override
    public int provideLayoutId() {
        return R.layout.activity_homework1;
    }

    @Override
    public Hw1ViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(Hw1ViewModel.class);
    }
}
