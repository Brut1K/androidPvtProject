package com.example.nikul.myapplication.presentation.screens.user.list;

import android.view.ViewGroup;
import com.example.domain.entity.UserEntity;
import com.example.nikul.myapplication.presentation.base.BaseAdapter;
import com.example.nikul.myapplication.presentation.base.BaseItemViewHolder;


public class UserAdapter extends BaseAdapter<UserEntity,UserItemViewModel> {


    private boolean isClickable;

    @Override
    public BaseItemViewHolder<UserEntity, UserItemViewModel, ?> onCreateViewHolder(ViewGroup parent, int viewType) {


        return UserItemViewHolder.create(parent, new UserItemViewModel());
    }
}
