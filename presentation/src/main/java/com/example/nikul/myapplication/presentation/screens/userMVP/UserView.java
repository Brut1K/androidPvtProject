package com.example.nikul.myapplication.presentation.screens.userMVP;

import com.example.domain.entity.UserEntity;
import com.example.nikul.myapplication.presentation.base.BaseView;




public interface UserView extends BaseView {
   void  showUser(UserEntity userEntity);
}
