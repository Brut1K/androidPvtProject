package com.example.nikul.myapplication.classWork.classWork10;


import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.data.repository.UserRepositoryImpl;
import com.example.domain.entity.UserEntity;
import com.example.domain.interactors.GetUserByIdUseCase;
import com.example.nikul.myapplication.classWork.basepackage.BaseViewModel;
import com.example.nikul.myapplication.executor.UiThread;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserViewModel extends BaseViewModel {

    private GetUserByIdUseCase getUserByIdUseCase
            = new GetUserByIdUseCase(new UiThread(),new UserRepositoryImpl());
    public ObservableField<String> userName = new ObservableField<>("");
    public ObservableField<String> profileUrl = new ObservableField<>("");
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean progressVisible = new ObservableBoolean(false);

    public UserViewModel() {

        progressVisible.set(true);
        getUserByIdUseCase.get("id").subscribe(new Observer<UserEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("AAA", "onSubscribe");
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(UserEntity userEntity) {
                        Log.e("AAA", "onNext");
                        userName.set(userEntity.getUserName());
                        profileUrl.set(userEntity.getProfileUrl());
                        age.set(userEntity.getAge());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("AAA", "onError");

                    }

                    @Override
                    public void onComplete() {
                        progressVisible.set(false);
                        Log.e("AAA", "onComplete");
                    }
                });
    }

    @Override
    public void onResume() {


    }


    @BindingAdapter({"android:src", "bind:error"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Glide.with(view.getContext())
                .load(url).into(view);
    }

}
