package com.example.nikul.myapplication.homeWork.homeWork7;




import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.classWork.classWork7.PublishContract;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;


public class HomeWork7 extends AppCompatActivity implements PublishContract {
    private Button button;
    private PublishSubject<Integer> publishSubject = PublishSubject.create();
    private int count =0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework7);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentHW7 fragmentHW7 = new FragmentHW7();
        fragmentTransaction.add(R.id.containerHW7,fragmentHW7);
        fragmentTransaction.commit();
        button = findViewById(R.id.buttonHW7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            publishSubject.onNext(count);
            count++;
            }
        });
    }

    @Override
    public Observable<Integer> getPublishSubject() {
        return publishSubject;
    }
}
