package com.example.nikul.myapplication.classWork.classWork7;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nikul.myapplication.R;



public class SecondFragment extends Fragment {
    private static final String KEY_VALUE = "KEY_VALUE";

    public static SecondFragment getInstance(FragmentManager fragmentManager, int value) {

        SecondFragment fragment = (SecondFragment) fragmentManager.findFragmentByTag(SecondFragment.class.getSimpleName());

        if(fragment==null) {
            fragment = new SecondFragment();
        }

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_VALUE,value);
        fragment.setArguments(bundle);

        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle!=null){
            int value = bundle.getInt(KEY_VALUE);
        }

    }

    //с помощью inflater трансформиуем xml в объект View

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragmenttwo,container,false);
    }

    //всё что делали в активити в onCreate делаем здесь
    //инициализация UI
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
