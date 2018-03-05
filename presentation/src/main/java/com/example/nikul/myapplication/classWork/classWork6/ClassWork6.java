package com.example.nikul.myapplication.classWork.classWork6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.nikul.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class ClassWork6 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork6);
        recyclerView = findViewById(R.id.recyclerview);

        List<User> userList = new ArrayList<>();
        userList.add(new User("https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/A-small_glyphs.svg/1200px-A-small_glyphs.svg.png","Alex1","Bruckiy1"));
        userList.add(new User("http://www.fishfun.nl/images/stories/virtuemart/product/not-giant-enough-letter-a.jpg","Alex2","Bruckiy2"));
        userList.add(new User("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDbOotGBtpBZGJvS8Ovvcxi0qQL8zjiM6Hc7ZjUpV2FxUukh12","Alex3","Bruckiy3"));
        userList.add(new User("http:","Alex4","Bruckiy4"));
        userList.add(new User("http:","Alex5","Bruckiy5"));
        userListAdapter = new UserListAdapter();
        userListAdapter.setItemList(userList);
        userListAdapter.setListener(new UserListAdapter.OnUserClickListener() {
            @Override
            public void onClick(User user, int position) {
                Toast.makeText(ClassWork6.this,user.getName()+position,Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(userListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
   //отступы и оформление item     recyclerView.getItemDecorationAt()



    }
}
