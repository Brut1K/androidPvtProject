package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.parsers;

import android.content.Context;

import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.entity.School;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;

import static com.example.nikul.myapplication.homeWork.homeWork6.it_academy.view.UI.print;

public class ParseJson extends Parser {

    public School parse(Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader
                    (new FileReader(new File(context.getFilesDir(),"school.json")));
            //пишем через билдер, если хотим переопределить какие-то конверторы,
            // в данном случае дату
            GsonBuilder builder = new GsonBuilder() .registerTypeAdapter(Date.class, new DateConvert());
            Gson gson = builder.create();
            School school = gson.fromJson(bufferedReader, School.class);
            return school;
        } catch (Exception e) {
            print("Невозможно открыть json error = " + e.toString());
            return null;
        }
    }
}
