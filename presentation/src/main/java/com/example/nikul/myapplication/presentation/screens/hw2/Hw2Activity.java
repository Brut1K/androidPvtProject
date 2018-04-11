package com.example.nikul.myapplication.presentation.screens.hw2;

import android.arch.lifecycle.ViewModelProviders;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.databinding.ActivityHomework2Binding;
import com.example.nikul.myapplication.presentation.base.BaseMVVMActivity;



public class Hw2Activity extends BaseMVVMActivity<ActivityHomework2Binding,Hw2ViewModel> {
    @Override
    public int provideLayoutId() {
        return R.layout.activity_homework2;
    }

    @Override
    public Hw2ViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(Hw2ViewModel.class);
    }
}
