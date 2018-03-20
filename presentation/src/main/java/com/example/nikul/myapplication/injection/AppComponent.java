package com.example.nikul.myapplication.injection;


import com.example.data.net.RestApi;
import com.example.data.net.RestService;
import com.example.nikul.myapplication.presentation.screens.user.UserViewModel;

import javax.inject.Singleton;
import dagger.Component;

//связующее звено между классами с Injectom и самим дагером
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(UserViewModel userViewModel);
    void inject(RestService RestService);
    void inject(RestApi restApi);

}
