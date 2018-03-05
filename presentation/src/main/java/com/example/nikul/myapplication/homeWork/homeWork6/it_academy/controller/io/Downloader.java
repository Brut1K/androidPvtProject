package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.io;



import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.nikul.myapplication.homeWork.homeWork6.it_academy.view.UI.print;


public class Downloader {
    final String  XMLLINK = "http://kiparo.ru/t/school.xml";
    final String JSONLINK = "http://kiparo.ru/t/school.json";


    public File download(Context context) {
        Log.e("AAA","startDL");
        File file = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL(JSONLINK);
            HttpURLConnection httpURLConnection =
                    (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                file = new File(context.getFilesDir(),"school.json");
                fileOutputStream = new FileOutputStream(file);
                int byteRead = -1;
                byte[] buffer = new byte[4096];
                while ((byteRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, byteRead);
                }
            } else {
                print("Данные не найдены, response code = "
                        + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            print("Невозможно скачать файл");
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    print("Невозможно закрыть inputStream");
                }
            if (fileOutputStream != null)
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    print("Невозможно закрыть fileOutputStream");
                }
        }
        Log.e("AAA","finishDL");
        return file;
    }
}


