package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller;

import by.it_academy.controller.utils.SearchFactory;
import by.it_academy.controller.utils.Searcher;
import by.it_academy.entity.School;
import by.it_academy.controller.io.Downloader;
import by.it_academy.controller.parsers.ParseJson;
import by.it_academy.controller.parsers.ParseXML;
import by.it_academy.controller.parsers.Parser;
import by.it_academy.view.UI;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it_academy.view.UI.print;

public class Manager {

    private static Manager manager;
    private School school;
    private UI ui;

    /**
     * Singleton
     * @return
     */
    public static Manager getInstance() {
        if(manager==null){
            manager = new Manager();
        }
        return manager;
    }



    public void setUi(UI ui){
        this.ui = ui;
    }

    /**
     * Загружает данные из интернета и парсит их в зависимости от формата
     * @param format Формат данных
     */
    public void createSchoolFromWeb(String format){
        Downloader dl = new Downloader();
        File f = new File(dl.download(format));
        if(f.exists()) {
            Parser parser;
            if (format.equals("xml")) {
                parser = new ParseXML();
            } else {
                parser = new ParseJson();
            }
            school = parser.parse();
            UI.dlAndParsechecker = true;
            ui.info(school);
        } else {
            print("Произошла ошибка указанная выше");
        }
    }

    /**
     * Поиск ученика по заданным параметрам
     * @param choice выбор варианта поиска
     * @param attr данные для поиска
     */
    public void search(int choice, String attr ){
        SearchFactory sf = new SearchFactory();
        Searcher searcher = sf.createSearcher(choice);
        ui.info(searcher.search(school,attr));
    }


    /**
     * Проверка вводимых пользователем данных
     * @param s данные, введенные пользователем
     * @return
     */
    public boolean inputchecker(String s){
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    /**
     * Вывод расписания школы
     */
    public void schedule(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<school.getGroups().size();i++){
            sb.append(school.getGroups().get(i).getGroupName());
            sb.append(": ");
            sb.append(school.getGroups().get(i).getSchedule());
            sb.append("\n");
        }
        print(sb.toString());
    }

    /**
     * Вывод именниников в текущем и следующем месяце
     */
    public void birthdays(){
        GregorianCalendar gc = new GregorianCalendar();
        GregorianCalendar gcStudent = new GregorianCalendar();
        for(int i = 0;i<school.getGroups().size();i++){
            for(int j = 0;j<school.getGroups().get(i).getStudents().size();j++){
                gcStudent.setTime(school.getGroups().get(i).getStudents().get(j).getbDay());
                if(((gcStudent.get(GregorianCalendar.MONTH)-gc.get(GregorianCalendar.MONTH)<=1)&&
                        (gcStudent.get(GregorianCalendar.MONTH)>=gc.get(GregorianCalendar.MONTH)))||
                        (gc.get(GregorianCalendar.MONTH)==12&&gcStudent.get(GregorianCalendar.MONTH)==1)){
                   ui.info(school.getGroups().get(i).getStudents().get(j));
                }
            }
        }



    }




}
