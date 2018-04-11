package com.example.nikul.myapplication.presentation.screens.userMVP;

import android.util.Log;
import com.example.domain.entity.UserEntity;
import com.example.domain.interactors.GetUserByIdUseCase;
import com.example.nikul.myapplication.app.App;
import com.example.nikul.myapplication.presentation.screens.user.list.UserAdapter;
import javax.inject.Inject;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class SingInUserPresenter extends UserPresenter {
    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public UserAdapter userAdapter = new UserAdapter();

    @Inject
    public GetUserByIdUseCase getUserByIdUseCase;

    public SingInUserPresenter() {
        view.showProgress();
        getUserByIdUseCase.get("77FD7B52-0CC8-FDB6-FF13-8B586A43DA00")
                .subscribe(new Observer<UserEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("AAA", "onSubscribe");
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(UserEntity userEntity) {
                        Log.e("AAA", "onNext");
                        view.showUser(userEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("AAA", "onError");
                        view.showError(e);

                    }

                    @Override
                    public void onComplete() {
                        view.dismissProgress();
                        Log.e("AAA", "onComplete");
                    }
                });


    }


    @Override
    public UserAdapter getUserAdapter() {
        return userAdapter;
    }

    @Override
    public void onUserClick() {

    }
}

