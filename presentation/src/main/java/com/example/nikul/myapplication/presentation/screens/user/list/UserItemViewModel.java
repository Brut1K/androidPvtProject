package com.example.nikul.myapplication.presentation.screens.user.list;



import android.databinding.ObservableField;

import com.example.domain.entity.UserEntity;
import com.example.nikul.myapplication.presentation.base.BaseItemViewModel;

public class UserItemViewModel extends BaseItemViewModel<UserEntity> {

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> age = new ObservableField<>("");



    @Override
    public void setItem(UserEntity userEntity, int position) {
        name.set(userEntity.getUserName());
        age.set(String.valueOf(userEntity.getAge()));
    }
}
