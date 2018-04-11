package com.example.nikul.myapplication.presentation.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.nikul.myapplication.BR;


public abstract class BaseMVVMActivitywithRouter<
        Binding extends ViewDataBinding,
        ViewModel extends BaseViewModel,
        R extends Router>
        extends AppCompatActivity {


    protected Binding binding;
    protected ViewModel viewModel ;
    @Nullable
    protected R router;


    public abstract int provideLayoutId();
    public abstract ViewModel   provideViewModel();
    public R provideRouter(){
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = provideViewModel();
        binding = DataBindingUtil.setContentView(this, provideLayoutId());
        binding.setVariable(BR.viewModel,viewModel);

        viewModel.attachRouter(router);
        router = provideRouter();

        Log.e("BaseMVVMActivity",viewModel.toString());

    }

    @Override
    protected void onStart() {
        super.onStart();
       viewModel.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewModel.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        router = null;
        viewModel.detachRouter();
    }
}
