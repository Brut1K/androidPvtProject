package com.example.nikul.myapplication.classWork.classWork7;

import android.app.Activity;
import android.content.Context;
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

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;


public class OneFragment extends Fragment {
    private static final String KEY_VALUE = "KEY_VALUE";
    private TextView textView;
    private PublishContract publishContract;
    private Disposable disposable;

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
        textView = view.findViewById(R.id.textViewfragment);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subscribe();
            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onPause() {
        super.onPause();
        if(disposable!=null){
            disposable.dispose();
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if(activity!=null){
            publishContract = (PublishContract) activity;
        }
    }


    @Override
    public void onDetach() {
        publishContract = null;
        super.onDetach();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ClassWork7 activity = (ClassWork7)getActivity();
    }

    private void subscribe(){
        disposable = publishContract.getPublishSubject()
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        //можно сделать промежуточные действия(в БД сохранить)
                    }
                })
                //преобразуем тип данных, трансформируем из любого типа в любой тип
                .map(new Function<Integer, String>() {
                    public String apply(Integer integer) throws Exception{
                        return String.valueOf(integer);
                    }
                })
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                })
                .map(new Function<String, Integer>() {

                    public Integer apply(String s) throws Exception {
                        return Integer.parseInt(s);
                    }
                })

                //фильтр задает условие для пропуска данных дальше
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        if(integer%2==0){
                            return false;
                        } else {
                            return true;
                        }
                    }
                })
                //пропускает дальше указанное количество уведомлений
                .take(50)
                //до subscribe ничего не будет работать
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        //сюда прилетают данные
                        textView.setText(integer.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        //сюда прилетают ошибки
                    }
                });
    }
}
