package com.example.nikul.myapplication.homeWork.homeWork12;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import com.example.domain.interactors.GetUserByIdUseCase;
import com.example.nikul.myapplication.R;


public class HomeWork12 extends AppCompatActivity{

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private GetUserByIdUseCase getUserByIdUseCase;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homewrok12);
        recyclerView = findViewById(R.id.hw12RecyclerView);
 //       List<UserEntity> list = getUserByIdUseCase.get();
        userAdapter = new UserAdapter();

    }
}
