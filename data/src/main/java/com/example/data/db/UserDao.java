package com.example.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.data.entity.User;

import java.util.List;
import io.reactivex.Flowable;


//аннотация для рума, чтобы он сам сделал имплементацию??
@Dao
public interface UserDao {

    //говорит руму, что все что мы подаем в метод нужно сохранить в бд
    @Insert
    void insert(List<User> userList);

    @Query("SELECT * FROM User")
    Flowable<List<User>> getAll();

    @Query("SELECT * FROM User WHERE id = :id LIMIT 1")
    Flowable<List<User>> getById(String id);

    @Query("DELETE FROM User")
    void deleteAll();

}
