package com.example.data.net;


import android.util.Log;

import com.example.data.entity.Data;
import com.example.data.entity.Root;
import com.example.data.entity.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class RestService {

    private RestApi restApi;

    @Inject
    public RestService(RestApi restApi) {
        this.restApi = restApi;
    }


    public Observable<List<User>> loadUsers(){
        return restApi.loadUsers();
    }


    public Observable<User> loadUserById(String id){
        return restApi.loadUserById(id);
    }


    public Observable<Root> loadTrends(){
        Log.e("RestService","loadTrends");
        return restApi.loadTrends();

    }


}
