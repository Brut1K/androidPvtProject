package com.example.nikul.myapplication.presentation.base;



public interface BaseView {
    void showProgress();
    void dismissProgress();
    void showError(Throwable e);


}
