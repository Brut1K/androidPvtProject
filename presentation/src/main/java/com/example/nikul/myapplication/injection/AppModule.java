package com.example.nikul.myapplication.injection;


import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import com.example.data.db.AppDatabase;
import com.example.data.net.RestApi;
import com.example.data.net.RestService;
import com.example.data.repository.UserRepositoryImpl;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.interactors.GetUserByIdUseCase;
import com.example.domain.repository.UserRepository;
import com.example.nikul.myapplication.BuildConfig;
import com.example.nikul.myapplication.executor.UiThread;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.plugins.RxJavaPlugins;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    static Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public static Context getContext(){
        return context;
    }

    @Provides
    @Singleton
    public PostExecutionThread getUiThread(){
        Log.e("PostExecutionThread","create");
        return new UiThread();

    }

//    @Binds
//    public abstract PostExecutionThread getUiThread(UiThread uiThread);




    @Provides
    @Singleton
    @Named("rep2")
    public UserRepository getUserRepository2(Context context,RestService restService,AppDatabase appDatabase) {
        Log.e("UserRepository","create");
        return new UserRepositoryImpl(context,restService,appDatabase);
    }

    @Provides
    @Singleton
    public RestApi getRestApi(Retrofit retrofit){
        return retrofit.create(RestApi.class);
    }


    @Provides
    @Singleton
    public Retrofit getRetrofit(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
    //            .baseUrl("https://api.backendless.com/ECB6B4FC-59A4-8B6B-FFC1-347C441D0000/A095639C-21D1-B2AA-FF69-AFBAFCC66200/")
                .baseUrl("https://api.giphy.com/v1/gifs/")
                .build();

//        ссылку сделать для дебага и релиза в градле

    }


    @Provides
    @Singleton
    public OkHttpClient getOkHttp() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS);
           if(BuildConfig.DEBUG) {
               HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
               httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
               builder.addInterceptor(httpLoggingInterceptor);
           }
          return builder.build();
    }





    @Provides
    @Singleton
    public Gson getGson(){
        return new GsonBuilder()
                .create();

    }


    @Provides
    @Singleton
    public AppDatabase getAppDatabase(Context context){
        AppDatabase appDatabase = Room
                .databaseBuilder(context,AppDatabase.class,"database")
                .fallbackToDestructiveMigration()
                .build();
        return appDatabase;
    }

}
