package com.example.nikul.myapplication.homeWork.homeWork9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.example.nikul.myapplication.BR;
import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.databinding.ActivityHomework9Binding;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;


public class HomeWork9 extends AppCompatActivity {
    private User user;
    private User user2;
    Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        user = new User("Alex", "30", true, "https://pp.userapi.com/c10611/u14788377/-6/y_7fdf5e4c.jpg");
        user2 = new User("Zhenya", "27", false, "https://pp.userapi.com/c624417/v624417365/2dcca/EmwIh8ZtfBo.jpg");


        final ActivityHomework9Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_homework9);
        binding.setMyUser(user);


        Observable<Long> values = Observable.interval(1000, TimeUnit.MILLISECONDS);

        disposable = values
                .map(new Function<Long, Integer>() {
                    @Override
                    public Integer apply(Long aLong) throws Exception {
                        Log.e("AAA", String.valueOf(aLong));
                        Log.e("AAA",user.toString());
                        return aLong.intValue();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer == 3;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer aLong) throws Exception {
                        Log.e("AAA", aLong.toString());
                        user.setName(user2.getName());
                        user.age.set("44");
                        disposable.dispose();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

    }

}

