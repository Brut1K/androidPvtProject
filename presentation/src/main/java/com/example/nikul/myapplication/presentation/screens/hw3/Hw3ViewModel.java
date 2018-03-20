package com.example.nikul.myapplication.presentation.screens.hw3;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.nikul.myapplication.presentation.base.BaseViewModel;



public class Hw3ViewModel extends BaseViewModel {

    @Override
    public void createInject() {

    }

    public ObservableField<String> editText = new ObservableField<>("");
    public ObservableField<String> buttonName = new ObservableField<>("");
    public ObservableField<String> textView = new ObservableField<>("");
    public ObservableField<String> imageViewUrl = new ObservableField<>("");


    public Hw3ViewModel() {
        Log.e("AAA","create HW3ViewModel");
        editText.set("asd");
        buttonName.set("Загрузить");
        textView.set("defaultText");
        imageViewUrl.set("https://pp.userapi.com/c10611/u14788377/-6/y_7fdf5e4c.jpg");
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

    @BindingAdapter({"android:src", "bind:error"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Glide.with(view.getContext())
                .load(url).into(view);
    }
}