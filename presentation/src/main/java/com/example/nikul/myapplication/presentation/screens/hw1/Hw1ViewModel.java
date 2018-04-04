package com.example.nikul.myapplication.presentation.screens.hw1;


import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.app.App;
import com.example.nikul.myapplication.presentation.base.BaseViewModel;

import javax.inject.Inject;

public class Hw1ViewModel extends BaseViewModel{

    @Inject
    Context context;

    public ObservableField<String> button = new ObservableField<>("");
    public ObservableField<String> leftText = new ObservableField<>("");
    public ObservableField<String> rightText = new ObservableField<>("");
    private String temp;

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public Hw1ViewModel() {
        button.set(context.getResources().getString(R.string.button1));
        leftText.set(context.getResources().getString(R.string.firsttext));
        rightText.set(context.getResources().getString(R.string.secondtext));
    }

    public void switchText(View view){
        temp = leftText.get();
        leftText.set(rightText.get());
        rightText.set(temp);
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
