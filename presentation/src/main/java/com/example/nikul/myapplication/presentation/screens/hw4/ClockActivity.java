package com.example.nikul.myapplication.presentation.screens.hw4;


import android.arch.lifecycle.ViewModelProviders;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.databinding.ActivityClockBinding;
import com.example.nikul.myapplication.presentation.base.BaseMVVMActivity;


public class ClockActivity extends BaseMVVMActivity<ActivityClockBinding,ClockViewModel> {
    @Override
    public int provideLayoutId() {
        return R.layout.activity_clock;
    }

    @Override
    public ClockViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(ClockViewModel.class);
    }
}
