package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.utils;

import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.entity.School;
import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.entity.Student;

import java.util.List;

/**
 * Интерфейс для всех поисков
 */
public interface Searcher {
    List<Student> search(School school, String s);
}
