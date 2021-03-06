package com.example.nikul.myapplication.app;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.example.nikul.myapplication.injection.AppComponent;
import com.example.nikul.myapplication.injection.AppModule;
import com.example.nikul.myapplication.injection.DaggerAppComponent;
import io.fabric.sdk.android.Fabric;

//запускается при старте приложения, прописан в манифесте

public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
       appComponent = DaggerAppComponent.builder()
       .appModule(new AppModule(this)).build();

    }
}
