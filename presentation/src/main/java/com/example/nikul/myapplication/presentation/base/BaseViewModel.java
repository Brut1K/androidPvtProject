package com.example.nikul.myapplication.presentation.base;


import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public abstract  void createInject();

    public BaseViewModel() {
        createInject();
    }

    public void onStart() {

    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onStop() {

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
