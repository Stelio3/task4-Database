package com.utad.david.task_3_fragments_lists.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.utad.david.task_3_fragments_lists.Dao.IUtadDao;
import com.utad.david.task_3_fragments_lists.Model.Communities;
import com.utad.david.task_3_fragments_lists.Model.Lesson;
import com.utad.david.task_3_fragments_lists.Model.Notes;
import com.utad.david.task_3_fragments_lists.Model.Notifications;
import com.utad.david.task_3_fragments_lists.Model.Teacher;
import com.utad.david.task_3_fragments_lists.Model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Creación de Base de datos
@Database(entities = {Communities.class}, version = 2)
@TypeConverters(LanguageConverter.class)
public abstract class UtadDatabase extends RoomDatabase {
    public abstract IUtadDao utadDao();
    //Creación de la instancia estática
    public static UtadDatabase INSTANCE;
    //Creación del Singleton
    public static UtadDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UtadDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UtadDatabase.class, "database_utad")
                            .fallbackToDestructiveMigration()
                            .addCallback(callbackData)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    // Creación del callBack
    static Callback callbackData = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new ClassAsynTask(INSTANCE).execute();
        }
    };
    private static class ClassAsynTask extends AsyncTask<Void,Void,Void>{

        public IUtadDao utadDao;

        public ClassAsynTask(UtadDatabase instance){
            utadDao = instance.utadDao();
        }

        //Método para rellenar los campos de la tabla
        @Override
        protected Void doInBackground(Void... voids) {
            HashMap<Integer, String> datos1 = new HashMap<Integer, String>();
            datos1.putAll((Map<? extends Integer, ? extends String>) Arrays.asList(new String[]{"19","3","Programame","Android App","****"}));
            HashMap<Integer, String> datos2 = new HashMap<Integer, String>();
            datos2.putAll((Map<? extends Integer, ? extends String>) Arrays.asList(new String[]{"32","2","SouthSummit","IOS App","*****"}));
            HashMap<Integer, String> datos3 = new HashMap<Integer, String>();
            datos3.putAll((Map<? extends Integer, ? extends String>) Arrays.asList(new String[]{"26","1","CompanyDay","WebApp","***"}));
            HashMap<Integer, String> datos4 = new HashMap<Integer, String>();
            datos4.putAll((Map<? extends Integer, ? extends String>) Arrays.asList(new String[]{"14","3","Hackaton","DatabaseApp","**"}));
            Communities developers = new Communities("Desarrollo de Software",1, "Dani", "Android", "9:00-10:45", "2018", datos1);
            Communities segurity = new Communities("Ciberseguridad",2, "David", "Android", "9:00-10:45", "2018", datos2);
            Communities bigData = new Communities("BigData",3, "Pedro", "Procesos", "11:00-12:45", "2018", datos3);
            Communities virtualReality = new Communities("Realidad Virtual",4, "David", "Android", "9:00-10:45", "2018", datos4);
            List<Communities> data = new ArrayList<>();
            data.add(developers);
            data.add(segurity);
            data.add(bigData);
            data.add(virtualReality);
            utadDao.deleteAll();
            utadDao.insertAll(data);
            return null;
        }
    }

}
