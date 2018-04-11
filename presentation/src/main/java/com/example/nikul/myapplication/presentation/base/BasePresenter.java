package com.example.nikul.myapplication.presentation.base;


import android.support.annotation.Nullable;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<View extends BaseView,R extends Router> {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Nullable
    protected R router;

    @Nullable
    protected View view;

    public void attach(R router,View view){
        this.view = view;
        this.router = router;
    }

    public void detach(){
        this.router = null;
        this.view = null;
    }

    public abstract  void createInject();

    public BasePresenter() {
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

    public void onDestroy(){
        if (compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }


}
