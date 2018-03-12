package com.example.nikul.myapplication.homeWork.homeWork7;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.classWork.classWork7.PublishContract;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class FragmentHW7 extends Fragment {
    private TextView textView;
    private PublishContract publishContract;
    private Disposable disposable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onPause() {
        if(disposable!=null){
            disposable.dispose();
        }
        super.onPause();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hw7,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.textViewHW7);
        subscribe();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if(activity!=null){
            publishContract = (PublishContract)activity;
        }
    }

    @Override
    public void onDetach() {
        publishContract = null;
        super.onDetach();
    }

    private void subscribe(){
        disposable = publishContract.getPublishSubject()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        textView.setText(integer.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        textView.setText("Throw Exception");
                    }
                });
    }
}
