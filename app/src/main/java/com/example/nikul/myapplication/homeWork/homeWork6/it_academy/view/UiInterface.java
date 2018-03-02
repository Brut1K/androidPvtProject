package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.view;

import by.it_academy.entity.School;
import by.it_academy.entity.Student;

import java.util.List;

public interface UiInterface {
    void prepareToWork();
    void mainMenu();
    void info(School school) ;
    void info(Student student);
    void info(List<Student> list);

}
