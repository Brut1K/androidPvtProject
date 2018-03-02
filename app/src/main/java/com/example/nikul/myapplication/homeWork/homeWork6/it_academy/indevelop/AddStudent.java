package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.indevelop;



import by.it_academy.entity.Parent;
import by.it_academy.entity.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import static by.it_academy.indevelop.AddParent.addParent;

public class AddStudent {
    public static Student addStudent(){
       Scanner scanner = new Scanner(System.in);
       Student student = new Student();
       //Вводим ФИО
        System.out.println("Введите имя ученика");
        student.setName(scanner.nextLine());
        System.out.println("Введите фамилию ученика");
        student.setSurname(scanner.nextLine());
        System.out.println("Введите отчество ученика");
        student.setLastname(scanner.nextLine());
        //Вводим дату рождения
        boolean checker = false;
        do {
            System.out.println("Введите дату рождения ученика в формате 31-12-2017/dd-MM-yyyy");
            String date = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                student.setbDay(sdf.parse(date));
                checker = true;
            } catch (ParseException e) {
                System.out.println("Формат неверный");
            }
        } while (checker==false);
        //Вводим родителей
        String command;
        List<Parent> parents = new ArrayList<>();
        do{
        System.out.println("Хотите добавить родителя?(введите \"да\" для добавления" +
                ", либо любой символ для ответа \"нет\")");
        command = scanner.nextLine();
        if(command.equals("да"))
            parents.add(addParent());
        } while (command.equals("да"));
        student.setParents(parents);


        return student;
    }
}
