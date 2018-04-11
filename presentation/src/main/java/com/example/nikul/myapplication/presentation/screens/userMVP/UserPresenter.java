package com.example.nikul.myapplication.presentation.screens.userMVP;


import com.example.nikul.myapplication.presentation.base.BasePresenter;
import com.example.nikul.myapplication.presentation.screens.user.list.UserAdapter;

public abstract class UserPresenter extends BasePresenter<UserView,UserRouter> {
    public abstract UserAdapter getUserAdapter();
    public abstract void onUserClick();
}
