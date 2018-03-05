package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller;

import android.content.Context;
import android.util.Log;

import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.utils.SearchFactory;
import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.utils.Searcher;
import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.entity.School;
import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.io.Downloader;
import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.parsers.ParseJson;
import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.parsers.ParseXML;
import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.parsers.Parser;
import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.entity.Student;
import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.view.UI;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.nikul.myapplication.homeWork.homeWork6.it_academy.view.UI.print;

public class Manager {

    private static Manager manager;
    private School school = null;
    private UI ui;

    public School getSchool() {
        return school;
    }

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
     * @param context Формат данных
     */
    public void createSchoolFromWeb(Context context){
        Log.e("AAA","createSchoolfromWeb start");
        Downloader dl = new Downloader();
        File f = dl.download(context);
        if(f.exists()) {
            Parser parser = new ParseJson();

            school = parser.parse(context);
            UI.dlAndParsechecker = true;
        } else {
            print("Произошла ошибка указанная выше");
        }
    }

    /**
     * Поиск ученика по заданным параметрам
     * @param choice выбор варианта поиска
     * @param attr данные для поиска
     */
    public List<Student> search(int choice, String attr ){
        SearchFactory sf = new SearchFactory();
        Searcher searcher = sf.createSearcher(choice);
        return searcher.search(school,attr);
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
