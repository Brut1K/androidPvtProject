package com.example.nikul.myapplication.classWork.classWork10;


import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.domain.entity.UserEntity;
import com.example.nikul.myapplication.classWork.basepackage.BaseViewModel;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel extends BaseViewModel {

    public ObservableField<String> userName = new ObservableField<>("");
    public ObservableField<String> profileUrl = new ObservableField<>("");
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean progressVisible = new ObservableBoolean(false);

    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Override
    public void onResume() {

        progressVisible.set(true);
        Observable.create(new ObservableOnSubscribe<UserEntity>() {
            @Override
            public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception {
                Thread.sleep(5000);
                UserEntity entity = new UserEntity("super userName",20,"https://pp.userapi.com/c10611/u14788377/-6/y_7fdf5e4c.jpg");
                emitter.onNext(entity);
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())



                .subscribe(new Observer<UserEntity>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("AAA","onSubscribe");
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(UserEntity userEntity) {
                Log.e("AAA","onNext");
                userName.set(userEntity.getUserName());
                profileUrl.set(userEntity.getProfileUrl());
                age.set(userEntity.getAge());
            }

            @Override
            public void onError(Throwable e) {
                Log.e("AAA","onError");

            }

            @Override
            public void onComplete() {
                progressVisible.set(false);
                Log.e("AAA","onComplete");
            }
        }) ;

    }



    @BindingAdapter({"android:src", "bind:error"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Glide.with(view.getContext())
                .load(url).into(view);
    }

    @Override
    public void onPause() {
        if(compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
