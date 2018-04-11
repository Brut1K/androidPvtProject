package com.example.data.net;


import android.util.Log;

import com.example.data.entity.Error;
import com.example.data.entity.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Observable;


@Singleton
public class RestService {

    private ErrorTransformer errorTransformer;
    private RestApi restApi;

    @Inject
    public RestService(RestApi restApi,ErrorTransformer errorTransformer) {
        this.restApi = restApi;
        this.errorTransformer = errorTransformer;
    }


    public Observable<List<User>> loadUsers(){
        return restApi.loadUsers()
                .compose(errorTransformer.<List<User>, Error>parseHttpError());
    }


    public Observable<User> loadUserById(String id){
        return restApi.loadUserById(id);
    }





}
