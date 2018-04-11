package com.example.nikul.myapplication.presentation.screens.userMVP;


import android.app.Activity;
import android.content.Intent;

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
