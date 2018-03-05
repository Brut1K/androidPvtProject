package com.example.nikul.myapplication.homeWork.homeWork6.it_academy.controller.parsers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import static com.example.nikul.myapplication.homeWork.homeWork6.it_academy.view.UI.print;

/**
 * Класс, который помогает конвертирвать дату
 */

public class DateConvert implements JsonDeserializer<Date>{

        private final String[] FORMATS = new String[]{
            "dd-MM-yyyy HH:mm",
            "dd-MM-yyyy"
        };

    /**
     * Конвертор даты для json
     * @param json
     * @param typeOfT
     * @param context
     * @return
     * @throws JsonParseException
     */
    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        for(String format:FORMATS   ){
            try{
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
                sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
                return sdf.parse(json.getAsString());
            } catch(Exception e){

            }
        }

        return null;
    }

    /**
     * Конвертор даты из String
     * @param s
     * @return
     */
    public static Date parseData(String s){
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.forLanguageTag("by"));
        try {
            date = sdf.parse(s);
            return date;
        } catch(ParseException e){
            print("Формат неверный");
        }
        return null;
    }
}
