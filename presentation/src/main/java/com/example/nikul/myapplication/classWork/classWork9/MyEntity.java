package com.example.nikul.myapplication.classWork.classWork9;


import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

public class MyEntity {
    public ObservableField<String> text = new ObservableField<>(" ");
    public ObservableField<String> textButton = new ObservableField<>(" ");
    public ObservableBoolean buttonVisible = new ObservableBoolean(true);

    public ObservableField<String> getText() {
        return text;
    }

    public void setText(ObservableField<String> text) {
        this.text = text;
    }

    public ObservableField<String> getTextButton() {
        return textButton;
    }

    public void setTextButton(ObservableField<String> textButton) {
        this.textButton = textButton;
    }

    public MyEntity(String text, String textButton) {
        this.text.set(text);
        this.textButton.set(textButton);
    }

    public void buttonClick(View view){
        Log.e("MyEntity","button click");
        buttonVisible.set(false);
    }
}
