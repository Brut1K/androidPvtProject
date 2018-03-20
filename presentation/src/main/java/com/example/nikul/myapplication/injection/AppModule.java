package com.example.nikul.myapplication.injection;


import android.content.Context;

import com.example.data.net.RestApi;
import com.example.data.net.RestService;
import com.example.data.repository.UserRepositoryImpl;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.repository.UserRepository;
import com.example.nikul.myapplication.executor.UiThread;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AppModule {

    Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context getContext(){
        return context;
    }

    @Provides
    @Singleton
    public PostExecutionThread getUiThread(){
        return new UiThread();

    }

//    @Binds
//    public abstract PostExecutionThread getUiThread(UiThread uiThread);


    @Provides
    @Singleton
    @Named("rep1")
    public UserRepository getUserRepository(Context context,RestService restService) {
        return new UserRepositoryImpl(context,restService);
    }

    @Provides
    @Singleton
    @Named("rep2")
    public UserRepository getUserRepository2(Context context,RestService restService) {
        return new UserRepositoryImpl(context,restService);
    }

    @Provides
    @Singleton
    public RestApi getRestApi(Retrofit retrofit){
        return retrofit.create(RestApi.class);
    }


    @Provides
    @Singleton
    public Retrofit getRetrofit(Gson gson){
        return new Retrofit.Builder()
       //         .addConverterFactory()
        //        .addCallAdapterFactory()
     //           .baseUrl()
                .build();

//        сделать билд ретрофита и туда закинуть ссылку
//        ссылку сделать для дебага и релиза в градле
//        подключить библиотеку для gson с сайта ретрофита
    }




    @Provides
    @Singleton
    public Gson getGson(){
        return new GsonBuilder()
                .create();

    }

}
