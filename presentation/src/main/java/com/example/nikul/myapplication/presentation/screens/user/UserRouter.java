package com.example.nikul.myapplication.presentation.screens.user;


import android.app.Activity;
import android.content.Intent;
import android.databinding.ViewDataBinding;


import com.example.nikul.myapplication.presentation.base.Router;

public class UserRouter extends Router{

    public UserRouter(Activity activity) {
        super(activity);
    }

    public void navigateToUser(String id){
        Intent intent = new Intent(getActivity(),UserActivity.class);
        intent.putExtra("key",id);
        getActivity().startActivity(intent);

        //альтернативный вариант
     //   UserActivity.show(getActivity(),id);
    }




}
