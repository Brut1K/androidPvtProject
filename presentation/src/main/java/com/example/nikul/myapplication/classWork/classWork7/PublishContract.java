package com.example.nikul.myapplication.classWork.classWork7;


import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public interface PublishContract {

    Observable<Integer> getPublishSubject();


}
