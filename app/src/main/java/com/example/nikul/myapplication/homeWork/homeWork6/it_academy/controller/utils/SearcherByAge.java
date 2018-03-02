package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.utils;

import by.it_academy.entity.School;
import by.it_academy.entity.Student;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Поиск ученика по возрасту
 */
public class SearcherByAge implements Searcher {
    @Override
    public List<Student> search(School school, String s) {
        int age = Integer.parseInt(s);
        List<Student> studentList = new ArrayList<>();
        GregorianCalendar curDate = new GregorianCalendar();
        GregorianCalendar calendar = new GregorianCalendar();
        for (int i = 0; i < school.getGroups().size(); i++) {
            for (int j = 0; j < school.getGroups().get(i).getStudents().size(); j++) {
                calendar.setTime(school.getGroups().get(i).getStudents().get(j).getbDay());
                if ((curDate.get(GregorianCalendar.YEAR) - calendar.get(GregorianCalendar.YEAR) == age) &&
                        curDate.get(GregorianCalendar.MONTH) <= calendar.get(GregorianCalendar.MONTH) &&
                        curDate.get(GregorianCalendar.DAY_OF_MONTH) <= calendar.get(GregorianCalendar.DAY_OF_MONTH)) {
                    studentList.add(school.getGroups().get(i).getStudents().get(j));
                }
            }
        }
        return studentList;
    }
}
