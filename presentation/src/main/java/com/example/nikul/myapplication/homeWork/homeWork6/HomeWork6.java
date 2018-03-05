package com.example.nikul.myapplication.homeWork.homeWork6;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.Manager;
import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.entity.Student;
import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.view.UI;

import java.util.ArrayList;
import java.util.List;

public class HomeWork6 extends AppCompatActivity {
    private EditText editText;
    private RecyclerView recyclerView;
    private StudentListAdapter studentListAdapter;
    private UI ui;
    private Manager manager;
    private List<Student> students;
    private MyWatcherListener myWatcherListener;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework6);
        editText = findViewById(R.id.edittextHW6);
        recyclerView = findViewById(R.id.recyclerviewHW6);
        myWatcherListener = new MyWatcherListener();
        ui = new UI();
        manager = Manager.getInstance();
        students = new ArrayList<>();

        studentListAdapter = new StudentListAdapter();

        final Context context = this;

        recyclerView.setAdapter(studentListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);

        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                ui.prepareToWork(context);

                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                studentListAdapter.setStudents(students = manager.search(1,editText.getText().toString()));
            }
        };
        asyncTask.execute();


    }

    @Override
    protected void onResume() {
        super.onResume();
        editText.addTextChangedListener(myWatcherListener);
        if(manager.getSchool()!=null) {
            students = manager.search(1, editText.getText().toString());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        editText.removeTextChangedListener(myWatcherListener);
    }


    private class MyWatcherListener implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.e("TextWatcher","afterTextChanged");
            editText.getText();
            students = manager.search(1,editText.getText().toString());
            studentListAdapter.setStudents(students);
        }
    }
}
