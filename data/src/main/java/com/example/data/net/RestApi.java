package com.example.data.net;


import com.example.data.entity.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {


    @GET("data/User")
    Observable<List<User>> loadUsers();

    @GET("data/User/(id)")
    Observable<User> loadUserById(@Path("id")String id);
}
