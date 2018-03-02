package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.indevelop;



import by.it_academy.entity.Teacher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AddTeacher {
    public static Teacher addTeacher(){
        Scanner scanner = new Scanner(System.in);
        Teacher teacher = new Teacher();
        System.out.println("Введите имя тренера");
        teacher.setName(scanner.nextLine());
        System.out.println("Введите фамилию тренера");
        teacher.setSurname(scanner.nextLine());
        System.out.println("Введите отчество тренера");
        teacher.setLastname(scanner.nextLine());
        boolean checker = false;
        do {
            System.out.println("Введите дату рождения тренера в формате 31-12-2017/dd-MM-yyyy");
            String date = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                teacher.setbDay(sdf.parse(date));
                checker = true;
            } catch (ParseException e) {
                System.out.println("Формат неверный");
            }
        } while (checker==false);
        return teacher;
    }
}
