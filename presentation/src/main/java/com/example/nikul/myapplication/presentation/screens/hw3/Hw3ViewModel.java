package com.example.nikul.myapplication.presentation.screens.hw3;

import android.databinding.BindingAdapter;
import com.example.nikul.myapplication.BuildConfig;
import com.example.nikul.myapplication.presentation.base.BaseViewModel;

import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;


public class Hw3ViewModel extends BaseViewModel {

    @Override
    public void createInject() {

    }

    public ObservableField<String> editText = new ObservableField<>("");
    public ObservableField<String> buttonName = new ObservableField<>("");
    public ObservableField<String> textView = new ObservableField<>("");
    public ObservableField<String> imageViewUrl = new ObservableField<>("");


    public Hw3ViewModel() {
        editText.set("");
        buttonName.set("Загрузить");
        textView.set("defaultText");
        imageViewUrl.set("");
    }

    @Override
    public String toString() {
        return "Hw3ViewModel{" +
                "editText=" + editText.get() +
                ", buttonName=" + buttonName.get() +
                ", textView=" + textView.get() +
                ", imageViewUrl=" + imageViewUrl.get() +
                '}';
    }



    public void changeURL(View view){
        imageViewUrl.set("https://pp.userapi.com/c10611/u14788377/-6/y_7fdf5e4c.jpg");
        textView.set(BuildConfig.API_ENDPOINT);
    }


}
