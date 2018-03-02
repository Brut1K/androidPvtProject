package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class School {



    private String schoolName;
    @SerializedName("group")
    private List<Group> groups;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", groups=" + groups +
                '}';
    }
}
