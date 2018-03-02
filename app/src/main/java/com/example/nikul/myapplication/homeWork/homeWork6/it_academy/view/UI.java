package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.view;


import by.it_academy.controller.Manager;
import by.it_academy.entity.School;
import by.it_academy.entity.Student;
import java.util.List;
import java.util.Scanner;


public class UI implements UiInterface {

    public static volatile boolean dlAndParsechecker = false;
    static String format;

    public static void main(String[] args) {
        UI ui = new UI();
        Manager manager = Manager.getInstance();
        manager.setUi(ui);
        ui.prepareToWork();
        ui.mainMenu();
    }

    /**
     * Подготовка данных к работе, скачивание и парсинг
     */
    @Override
    public void prepareToWork(){
        Scanner sc = new Scanner(System.in);
        Manager manager =Manager.getInstance();
        System.out.println("Здравствуйте, данные для работы находятся" +
                " на web-ресурсе. Какой формат данных скачать?\n" +
                "Выберите 1 для XML, либо 2 для JSON");
        String command;
        boolean checker = false;

        do {
            command = sc.nextLine();
            if (manager.inputchecker(command)) {
                switch (command) {
                    case "1": {
                        format = "xml";
                        checker = true;
                        break;
                    }
                    case "2": {
                        format = "json";
                        checker = true;
                        break;
                    }
                    default: {
                        System.out.println("Вы ввели некорректные данные\n" +
                                "\"Выберите 1 для XML, либо 2 для JSON\"");
                        break;
                    }
                }


            } else {
                System.out.println("Вы ввели некорректные данные\n" +
                        "\"Выберите 1 для XML, либо 2 для JSON\"");
            }

            if(checker) {
                Thread createschoolThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        manager.createSchoolFromWeb(format);
                    }
                });
                createschoolThread.start();
                while (!dlAndParsechecker) {
                    if (createschoolThread.isAlive()) {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print(".");
                    } else {
                        System.out.println("Произошла ошибка, попробуйте повторить попытку позже");
                        prepareToWork();
                    }
                }

            }
        } while (checker == false);
    }

    /**
     * Основное меню, где пользователь работает с данными
     */
    @Override
    public void mainMenu() {
        Manager manager = Manager.getInstance();
        Scanner sc = new Scanner(System.in);
        String comm;
        do {
            System.out.println("Выберите функцию, которой вы хотите воспользоваться:\n" +
                    "1. Поиск учеников\n" +
                    "2. Просмотр расписания\n" +
                    "3. Просмотр списка именинников в текущем и ближайщем месяце\n" +
                    "4. Завершение работы программы\n" +
                    "Введите цифру 1-4");
            comm = sc.nextLine();
            if (manager.inputchecker(comm)) {
                switch (comm) {
                    case "1": {
                        String searchChoice;
                        boolean invoke;
                        do {
                            System.out.println("Выберите вариант поиска:\n" +
                                    "1. По имени или фамилии\n" +
                                    "2. По возрасту\n" +
                                    "3. По названию группы\n" +
                                    "4. По имени педагога\n" +
                                    "5. Отменить поиск\n" +
                                    "Введите цифру 1-5");
                            searchChoice = sc.nextLine();
                            if (manager.inputchecker(searchChoice)) {
                                switch (searchChoice) {
                                    case "1": {
                                        System.out.println("Введите имя, фамилию или отчество(можно частично)");
                                        invoke = true;
                                        break;
                                    }
                                    case "2": {
                                        System.out.println("Введите возраст");
                                        invoke = true;
                                        break;
                                    }
                                    case "3": {
                                        System.out.println("Введите название группы");
                                        invoke = true;
                                        break;
                                    }
                                    case "4": {
                                        System.out.println("Введите фамилию педагога");
                                        invoke = true;
                                        break;
                                    }
                                    case "5": {
                                        System.out.println("Поиск отменен");
                                        invoke = false;
                                        break;
                                    }
                                    default: {
                                        System.out.println("Вы ввели некорректные данные");
                                        invoke = false;
                                        break;
                                    }
                                }
                                if (invoke) {
                                    manager.search(Integer.parseInt(searchChoice), sc.nextLine());
                                }
                            } else {
                                System.out.println("Вы ввели некорректные данные");
                            }
                        } while (!searchChoice.equals("5"));

                    }

                    case "2": {
                        System.out.println("Просмотр расписания");
                        manager.schedule();
                        break;
                    }
                    case "3": {
                        System.out.println("Просмотр списка именинников");
                        manager.birthdays();
                        break;
                    }
                    case "4": {
                        System.out.println("Завершение работы");
                        break;
                    }
                    default: {
                        System.out.println("Вы ввели некорректные данные");
                        break;
                    }
                }
            } else {
                System.out.println("Вы ввели некорректные данные");
            }

        } while (!comm.equals("4"));
    }

    /**
     * Вывод информации о школе
     * @param school
     */
    @Override
    public void info(School school) {
        int countGroup = 0;
        int countStudent = 0;
        for (int i = 0; i < school.getGroups().size(); i++) {
            countGroup++;
            countStudent = countStudent + school.getGroups().get(i).getStudents().size();
        }
        System.out.println("Были загружены данные о школе танцев:\n" +
                "Групп " + countGroup + " шт.\n" +
                "Учеников " + countStudent + " чел.");
    }

    /**
     * Вывод информации о ученике
     * @param student
     */
    @Override
    public void info(Student student){
        System.out.println("Имя: " + student.getName() + "\n" +
                "Фамилия: " + student.getSurname() + "\n" +
                "Отчество: " + student.getLastname() + "\n" +
                "Дата рождения: " + student.getbDay() + "\n");

    }

    /**
     * Вывод информации о группе учеников
     * @param list
     */
    @Override
    public void info(List<Student> list){
        for(int i = 0;i<list.size();i++){
            System.out.println((i+1)+". " + list.get(i).getSurname() +
                    " " + list.get(i).getName() + " " + list.get(i).getLastname());
        }
    }

    /**
     * Вывод заданного сообщения в консоль
     * @param s - сообщение
     */
    public static void print(String s){
        System.out.println(s);
    }

}

