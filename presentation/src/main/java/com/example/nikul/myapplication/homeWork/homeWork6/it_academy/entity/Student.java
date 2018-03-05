package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Student extends People {
    private Date bDay;
    private List<Parent> parents;
    private Map<Date,Boolean> payment;

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public Map<Date, Boolean> getPayment() {
        return payment;
    }

    public void setPayment(Map<Date, Boolean> payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Student{" +
                "bDay=" + bDay +
                ", parents=" + parents +
                ", payment=" + payment +
                ", name=" + super.getName() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(bDay, student.bDay) &&
                Objects.equals(super.getName(), student.getName()) &&
                Objects.equals(super.getLastname(), student.getLastname()) &&
                Objects.equals(super.getSurname(), student.getSurname());
    }

    @Override
    public int hashCode() {

        return Objects.hash(bDay);
    }
}
