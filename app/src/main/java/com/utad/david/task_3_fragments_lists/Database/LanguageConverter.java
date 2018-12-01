package com.utad.david.task_3_fragments_lists.Database;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.utad.david.task_3_fragments_lists.Model.Communities;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LanguageConverter {
    @TypeConverter
    public static HashMap<Integer, String> stringToHashMap(String value) {
        Type hashMapType = new TypeToken<HashMap<Integer, String>>() {}.getType();
        return new Gson().fromJson(value, hashMapType);
    }

    @TypeConverter
    public static String hashMapToString(HashMap<Integer, String> map) {
        Gson gson = new Gson();
        String json = gson.toJson(map);
        return json;
    }
}
