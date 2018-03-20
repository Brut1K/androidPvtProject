package com.example.data.repository;


import android.content.Context;

import com.example.data.entity.User;
import com.example.data.net.RestService;
import com.example.domain.entity.UserEntity;
import com.example.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

public class UserRepositoryImpl implements UserRepository {


    private Context context;
    private RestService restService;

    public UserRepositoryImpl(Context context, RestService restService) {
        this.context = context;
        this.restService = restService;
    }

    @Override
    public Observable<UserEntity> get(String id) {
//       return restService.loadUserById(id)
//        .map(new Function<User, UserEntity>() {
//            @Override
//            public UserEntity apply(User user) throws Exception {
//                return new UserEntity(user.getUsername(),user.getAge(),user.getProfileUrl());
//            }
//
//
//        });
              return Observable.create(new ObservableOnSubscribe<UserEntity>() {
            @Override
            public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception {
                Thread.sleep(5000);
                UserEntity entity = new UserEntity("super userName",20,"https://pp.userapi.com/c10611/u14788377/-6/y_7fdf5e4c.jpg");
                emitter.onNext(entity);
                emitter.onComplete();
            }
        });


    }

    @Override
    public Observable<List<UserEntity>> get() {
        return restService.loadUsers()
                .map(new Function<List<User>, List<UserEntity>>() {
                    @Override
                    public List<UserEntity> apply(List<User> users) throws Exception {

                        List<UserEntity> list = new ArrayList<>();
                        for(User user: users){
                            list.add(new UserEntity(user.getUsername(),
                                    user.getAge(),
                                    user.getProfileUrl()));

                        }
                        return list;
                    }
                });

        }



    @Override
    public Completable save() {
        return null;
    }

    @Override
    public Completable remove() {
        return null;
    }
}
