package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.utils;

public class SearchFactory {
    /**
     * Метод фабрики, который возвращает нам нужный тип поисковика
     * @param i Выбор пользователся по типу поиска
     * @return
     */
    public Searcher createSearcher(int i){
        switch(i){
            case 1:{
                return new SearcherByName();
            }
            case 2:{
                return new SearcherByAge();
            }
            case 3:{
                return new SearcherByGroup();
            }
            case 4:{
                return new SearcherByTeacher();
            }
            default:{
                break;
            }
        }
        return null;
    }
}
