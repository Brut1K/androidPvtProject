package com.example.nikul.myapplication.presentation.screens.user.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.domain.entity.UserEntity;
import com.example.nikul.myapplication.databinding.ItemUserrecyclerBinding;
import com.example.nikul.myapplication.presentation.base.BaseItemViewHolder;


public class UserItemViewHolder extends BaseItemViewHolder<UserEntity,UserItemViewModel,ItemUserrecyclerBinding> {



    public UserItemViewHolder(ItemUserrecyclerBinding binding, UserItemViewModel viewModel) {
        super(binding, viewModel);
    }

    public static UserItemViewHolder create(ViewGroup parent, UserItemViewModel userItemViewModel){
        ItemUserrecyclerBinding binding =
                ItemUserrecyclerBinding.inflate
                        (LayoutInflater.from(parent.getContext()),parent,false);

        return new UserItemViewHolder(binding,userItemViewModel);
    }
}
