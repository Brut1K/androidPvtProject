package com.example.nikul.myapplication.classWork.classWork7;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.nikul.myapplication.R;

import io.reactivex.subjects.PublishSubject;

public class ClassWork7 extends AppCompatActivity {

    private PublishSubject<Integer> publishSubject =
            PublishSubject.create()

    private TextView textView;
    private boolean isOneVisible;
    private static final String SHARED = "Shared name";
    private static final String KEY_VALUE = "KEY_VALUE";
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork7);
        textView = findViewById(R.id.viewInFragment);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment();
            }
        });
//проверяем, чтобы не залепить 2 фрагмента после сворачивания
        if(savedInstanceState == null){
            showFragment(OneFragment.getInstance(getSupportFragmentManager(),22));
        }

        getFilesDir();
      //  getExternalFilesDir()
        sharedPreferences = getSharedPreferences(SHARED,MODE_PRIVATE);
        sharedPreferences.edit().remove(KEY_VALUE);


    }


    @Override
    protected void onStart() {
        super.onStart();
        String text = sharedPreferences.getString(KEY_VALUE,"aa");
        textView.setText(text);

    }

    @Override
    protected void onStop() {
        super.onStop();
        sharedPreferences.edit().putString(KEY_VALUE,"Heo").apply();
    }

    private void changeFragment(){
        if(isOneVisible){
            showFragment(SecondFragment.getInstance(getSupportFragmentManager(),11));
            isOneVisible = false;
        }else {
            showFragment(OneFragment.getInstance(getSupportFragmentManager(),33));
            isOneVisible = true;
        }
    }

    private void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment,fragment.getClass().getSimpleName());
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }

}
