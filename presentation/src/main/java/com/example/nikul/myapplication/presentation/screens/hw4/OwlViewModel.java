package com.example.nikul.myapplication.presentation.screens.hw4;


import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.presentation.base.BaseViewModel;

import javax.inject.Inject;

public class OwlViewModel extends BaseViewModel{
    private AnimationDrawable owl;
    private ImageView imageView;

    @Inject
    public Context context;

    @Override
    public void createInject() {

    }

    public ObservableField<String> button = new ObservableField<>("");
    public ObservableField<Integer> id = new ObservableField<>(0);

    public OwlViewModel(){
        button.set("Start animation");
    }


    public void onClick(View view){
        imageView = view.getRootView().findViewById(R.id.owlImageView);
        owl = (AnimationDrawable) imageView.getBackground();
        owl.start();
    }








}
