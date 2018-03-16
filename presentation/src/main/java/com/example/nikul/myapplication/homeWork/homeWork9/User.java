package com.example.nikul.myapplication.homeWork.homeWork9;


import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

public class User {
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> age = new ObservableField<>("");
    public ObservableBoolean male = new ObservableBoolean(true);
    public ObservableField<String> image = new ObservableField<>("");

    public User(String name, String age, boolean male, String image) {
        this.name.set(name);
        this.age.set(age);
        this.male.set(male);
        this.image.set(image);
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public ObservableField<String> getAge() {
        return age;
    }

    public void setAge(ObservableField<String> age) {
        this.age = age;
    }

    public ObservableBoolean getMale() {
        return male;
    }

    public void setMale(ObservableBoolean male) {
        this.male = male;
    }

    public ObservableField<String> getImage() {
        return image;
    }

    public void setImage(ObservableField<String> image) {
        this.image = image;
    }
}
