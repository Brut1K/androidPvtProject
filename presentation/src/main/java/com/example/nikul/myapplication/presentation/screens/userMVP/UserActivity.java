package com.example.nikul.myapplication.presentation.screens.userMVP;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.domain.entity.UserEntity;
import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.presentation.base.BaseMVPActivity;


public class UserActivity
        extends BaseMVPActivity<UserPresenter,UserRouter>
        implements UserView {

//все клики делегируем в презентер,
// там создаем методы и отсюда просто дергаем методы презентера
    private static final String KEY_USER_ID ="KEY_USER_ID";

    public static void show(Activity activity, String id){
        Intent intent = new Intent(activity, UserActivity.class);
        intent.putExtra(KEY_USER_ID,id);
        activity.startActivity(intent);
    }

    @Override
    public int provideLayoutId() {
        return R.layout.activity_classwork10;
    }

    @Override
    public UserPresenter providePresenter() {
        return new SingInUserPresenter();
    }


    @Override
    public UserRouter provideRouter() {
        return new UserRouter(this);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(presenter.getUserAdapter());

        presenter.onUserClick();
        
    }

    @Override
    public void showUser(UserEntity userEntity) {
        //закидываем данные в xml сделав для них findViewById
    }
}
