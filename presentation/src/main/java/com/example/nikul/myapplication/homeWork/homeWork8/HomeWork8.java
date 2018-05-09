package com.example.nikul.myapplication.homeWork.homeWork8;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.classWork.classWork7.PublishContract;

import org.reactivestreams.Subscription;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;



public class HomeWork8 extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private Observable<Long> values;
    private Disposable disposable;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework8);
        button = findViewById(R.id.buttonHW8);
        textView = findViewById(R.id.textViewHW8);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subscribe();
            }
        });
    }

    @Override
    protected void onStop() {
        Log.e("AAA","onStop");
        if(disposable!=null) {
            Log.e("AAA", "dispose");
            disposable.dispose();
        }
        super.onStop();
    }

    private void subscribe() {
        if (disposable == null) {
            values = Observable.interval(1000, TimeUnit.MILLISECONDS);

            disposable = values
                    .map(new Function<Long, Integer>() {
                        @Override
                        public Integer apply(Long aLong) throws Exception {
                            Log.e("AAA", String.valueOf(aLong));
                            return aLong.intValue();
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .filter(new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer integer) throws Exception {
                            return integer % 2 == 0;
                        }
                    })
                    .subscribe(new Consumer<Integer>() {
                        @Override
                        public void accept(Integer aLong) throws Exception {
                            Log.e("AAA", aLong.toString());
                            textView.setText(aLong.toString());
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            textView.setText(throwable.getMessage());
                        }
                    });

        }
    }




}
