package com.example.data.net;


import com.example.data.entity.Data;
import com.example.data.entity.Root;
import com.example.data.entity.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {

    @GET("trending?api_key=LNUzsQFLm6xuc2aE7h6gUimo9TDf1hyh&limit=10")
    Observable<Root> loadTrends();



    @GET("data/User")
    Observable<List<User>> loadUsers();

    @GET("data/User/{objectId}")
    Observable<User> loadUserById(@Path("objectId")String id);
}
