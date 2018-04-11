package com.example.nikul.myapplication.presentation.screens.hw4;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.databinding.ActivityOwlBinding;
import com.example.nikul.myapplication.presentation.base.BaseMVVMActivity;


public class OwlActivity extends BaseMVVMActivity<ActivityOwlBinding,OwlViewModel> {
    @Override
    public int provideLayoutId() {
        return R.layout.activity_owl;
    }

    @Override
    public OwlViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(OwlViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.getRoot().findViewById(R.id.owlImageView).setBackgroundResource(R.drawable.sova_animation);
    }
}
