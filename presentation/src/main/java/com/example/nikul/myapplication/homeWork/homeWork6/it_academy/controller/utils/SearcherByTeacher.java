package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.utils;

import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.entity.School;
import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Поиск учеников определенного учителся
 */

public class SearcherByTeacher implements Searcher {
    @Override
    public List<Student> search(School school, String s) {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < school.getGroups().size(); i++) {
            if(school.getGroups().get(i).getTeacher().getSurname().toLowerCase().equals(s.toLowerCase())){
                for (int j = 0; j < school.getGroups().get(i).getStudents().size(); j++){
                    studentList.add(school.getGroups().get(i).getStudents().get(j));
                }
            }
        }
        return studentList;
    }
}
