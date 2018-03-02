package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static by.it_academy.view.UI.print;




public class Downloader {
    final String  XMLLINK = "http://kiparo.ru/t/school.xml";
    final String JSONLINK = "http://kiparo.ru/t/school.json";

    /**
     * Скачивает файл нужного формата.
     * @param format формат файла(xml,json)
     * @return Путь к скачанному файлу
     */
    public String download(String format) {

        String patternS = "(.+)"+"("+format +"$)";
        Pattern pattern = Pattern.compile(patternS);
        Matcher matcher = pattern.matcher(XMLLINK);
        String link;
        String filepath;
        if(matcher.matches()) {
            link = XMLLINK;
           filepath = "school.xml";
        } else{
            link = JSONLINK;
            filepath = "school.json";
        }
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection =
                    (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                File file = new File(filepath);
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
        return filepath;
    }
}


