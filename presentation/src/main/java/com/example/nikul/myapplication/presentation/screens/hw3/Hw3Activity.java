package com.example.nikul.myapplication.presentation.screens.hw3;

import android.arch.lifecycle.ViewModelProviders;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.databinding.ActivityHomework3Binding;
import com.example.nikul.myapplication.presentation.base.BaseMVVMActivity;



public class Hw3Activity extends BaseMVVMActivity<ActivityHomework3Binding,Hw3ViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_homework3;
    }

    @Override
    public Hw3ViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(Hw3ViewModel.class);
    }
}
