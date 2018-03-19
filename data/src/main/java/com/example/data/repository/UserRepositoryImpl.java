package com.example.data.repository;


import com.example.domain.entity.UserEntity;
import com.example.domain.repository.UserRepository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public Observable<UserEntity> get(String id) {
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
        return null;
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
