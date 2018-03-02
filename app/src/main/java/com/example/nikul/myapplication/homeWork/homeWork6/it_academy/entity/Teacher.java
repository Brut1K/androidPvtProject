package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.entity;

import java.util.Date;

public class Teacher extends People {
    private Date bDay;

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "bDay=" + bDay +
                '}';
    }
}
