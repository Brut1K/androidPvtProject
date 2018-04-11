package com.example.nikul.myapplication.presentation.screens.hw5;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.databinding.ActivityHomework5Binding;
import com.example.nikul.myapplication.presentation.base.BaseMVVMActivity;

public class Hw5Activity extends BaseMVVMActivity<ActivityHomework5Binding,Hw5ViewModel>{
    @Override
    public int provideLayoutId() {
        return R.layout.activity_homework5;
    }

    @Override
    public Hw5ViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(Hw5ViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.getViewModel().setImageView(binding.wifiView);
        binding.getViewModel().checkwifi();
    }
}
