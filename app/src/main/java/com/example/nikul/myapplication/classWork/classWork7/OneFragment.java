package com.example.nikul.myapplication.classWork.classWork7;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nikul.myapplication.R;


public class OneFragment extends Fragment {
    private static final String KEY_VALUE = "KEY_VALUE";
    private TextView textView;

    public static OneFragment getInstance(FragmentManager fragmentManager,int value) {

        OneFragment fragment = (OneFragment) fragmentManager.findFragmentByTag(OneFragment.class.getSimpleName());

        if(fragment==null) {
            fragment = new OneFragment();
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
        return getLayoutInflater().inflate(R.layout.fragmentone,container,false);
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
        ClassWork7 activity = (ClassWork7)getActivity();
    }
}
