package com.utad.david.task_3_fragments_lists.DataBaseConection.Database;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class LanguageConverter {
    //Convertidor de String a HashMap
    @TypeConverter
    public static HashMap<Integer, String> stringToHashMap(String value) {
        Type hashMapType = new TypeToken<HashMap<Integer, String>>() {}.getType();
        return new Gson().fromJson(value, hashMapType);
    }
    //Convertidor de HashMap a String
    @TypeConverter
    public static String hashMapToString(HashMap<Integer, String> map) {
        Gson gson = new Gson();
        String json = gson.toJson(map);
        return json;
    }
}
