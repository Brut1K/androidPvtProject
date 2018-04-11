package com.example.nikul.myapplication.presentation.screens.hw4;



import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import com.example.nikul.myapplication.app.App;
import com.example.nikul.myapplication.presentation.base.BaseViewModel;


public class Hw4ViewModel extends BaseViewModel {


    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public ObservableField<String> buttonOwl = new ObservableField<>("");
    public ObservableField<String> buttonClock = new ObservableField<>("");

    public Hw4ViewModel() {
        buttonOwl.set("Show Owl");
        buttonClock.set("Show clock");
    }

    public void startOwl(View view){
        Intent intent = new Intent(view.getContext(), OwlActivity.class);
        view.getContext().startActivity(intent);
    }

    public void startClock(View view){
        view.getContext().startActivity(new Intent(view.getContext(),ClockActivity.class));
    }




}
