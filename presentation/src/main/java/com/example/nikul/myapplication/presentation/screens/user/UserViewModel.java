package com.example.nikul.myapplication.presentation.screens.user;


import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.example.data.entity.Error;
import com.example.data.entity.ErrorType;
import com.example.domain.entity.UserEntity;
import com.example.domain.interactors.GetUserByIdUseCase;
import com.example.nikul.myapplication.app.App;
import com.example.nikul.myapplication.presentation.base.BaseAdapter;
import com.example.nikul.myapplication.presentation.base.BaseViewModel;
import com.example.nikul.myapplication.presentation.screens.user.list.UserAdapter;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserViewModel extends BaseViewModel<UserRouter> {



    public UserAdapter userAdapter = new UserAdapter();

    @Inject
    Context context;


    @Inject
    public GetUserByIdUseCase getUserByIdUseCase;


    public ObservableField<String> userName = new ObservableField<>("");
    public ObservableField<String> profileUrl = new ObservableField<>("");
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean progressVisible = new ObservableBoolean(false);

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public UserViewModel() {

        super();
        if(router!=null){
            router.navigateToUser("asd");
        }
        userAdapter.observeClick().subscribeActual(new Observer<BaseAdapter.ItemEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BaseAdapter.ItemEntity itemEntity) {
                //делаем что-то при клике на нужный item
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        progressVisible.set(false);
//        getUserByIdUseCase.get().subscribe(new Observer<List<UserEntity>>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.e("AAA", "onSubscribe");
//                        compositeDisposable.add(d);
//            }
//
//            @Override
//            public void onNext(List<UserEntity> userEntities) {
//
//                for(UserEntity user:userEntities){
//                    Log.e("name",user.getUserName());
//                    Log.e("URL",user.getProfileUrl());
//                    Log.e("age",String.valueOf(user.getAge()));
//
//
//                    userAdapter.setItems(userEntities);
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                if(e instanceof Error){
//                    Error myError = (Error)e;
//                    if(myError.getFriendlyError()== ErrorType.NO_INTERNET){
//
//                    } else if(myError.getFriendlyError()== ErrorType.SERVER_NOT_AVAILABLE){
//
//                    } else {
//
//                    }
//                }
//                else{
//
//                }
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
////        getUserByIdUseCase.get("77FD7B52-0CC8-FDB6-FF13-8B586A43DA00").subscribe(new Observer<UserEntity>() {
////                    @Override
////                    public void onSubscribe(Disposable d) {
////                        Log.e("AAA", "onSubscribe");
////                        compositeDisposable.add(d);
////                    }
////
////                    @Override
////                    public void onNext(UserEntity userEntity) {
////                        Log.e("AAA", "onNext");
////                        userName.set(userEntity.getUserName());
////                        profileUrl.set(userEntity.getProfileUrl());
////                        age.set(userEntity.getAge());
////                    }
////
////                    @Override
////                    public void onError(Throwable e) {
////                        Log.e("AAA", "onError");
////
////                    }
////
////                    @Override
////                    public void onComplete() {
////                        progressVisible.set(false);
////                        Log.e("AAA", "onComplete");
////                    }
//                });
    }

    @Override
    public void onResume() {


    }


    @BindingAdapter({"android:src", "bind:error"})
    public static void loadImage(ImageView view, String url, Drawable error) {

            Log.e("aaa","try");
            Glide.with(view.getContext())
                    .load(url).error(Glide.with(view.getContext()).load(error))
                    .into(view);

    }

}
