package com.example.nikul.myapplication.injection;


import com.example.data.net.RestApi;
import com.example.data.net.RestService;
import com.example.domain.interactors.GetUserByIdUseCase;
import com.example.nikul.myapplication.presentation.screens.hw1.Hw1ViewModel;
import com.example.nikul.myapplication.presentation.screens.hw4.Hw4ViewModel;
import com.example.nikul.myapplication.presentation.screens.hw5.Hw5ViewModel;
import com.example.nikul.myapplication.presentation.screens.user.UserViewModel;
import com.example.nikul.myapplication.presentation.screens.userMVP.SingInUserPresenter;

import javax.inject.Singleton;
import dagger.Component;

//связующее звено между классами с Injectom и самим дагером
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(UserViewModel userViewModel);
    void inject(RestService RestService);
    void inject(RestApi restApi);
    void inject(Hw1ViewModel hw1ViewModel);
    void inject(Hw4ViewModel hw4ViewModel);
    void inject(Hw5ViewModel hw5ViewModel);
    void inject(GetUserByIdUseCase getUserByIdUseCase);
    void inject(SingInUserPresenter singInUserPresenter);

}
