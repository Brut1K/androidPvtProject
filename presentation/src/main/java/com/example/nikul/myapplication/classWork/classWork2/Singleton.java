package com.example.nikul.myapplication.classWork.classWork2;

/**
 * Created by nikul on 09.02.2018.
 */

public class Singleton {

    private static Singleton singleton = new Singleton();
    public String text;
    private Singleton(){

    }

    public static Singleton getInstance(){
        return singleton;
    }
}
