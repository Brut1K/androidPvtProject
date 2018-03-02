package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.indevelop;


import by.it_academy.entity.Group;
import by.it_academy.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static by.it_academy.indevelop.AddStudent.addStudent;
import static by.it_academy.indevelop.AddTeacher.addTeacher;

public class AddGroup {
    public static Group addGroup(){
        Group group = new Group();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название группы");
        group.setGroupName(scanner.nextLine());
        group.setTeacher(addTeacher());
        List<Student> studentList = new ArrayList<>();
        boolean check = true;
        String a;
        do {
            System.out.println("Добавить в группу ученика(да/нет)");
            a = scanner.nextLine();
            if (a.equals("да")) {
                studentList.add(addStudent());
            } else if (a.equals("нет")){
                group.setStudents(studentList);
                check = false;
            } else {
                System.out.println("Введите \"да\" или \"нет\"");
            }
        } while(check);
        return group;
    }
}
