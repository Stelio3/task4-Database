package com.utad.david.task_3_fragments_lists.DataBaseConection.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.ILessonDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.IUtadDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Communities;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Lesson;
import com.utad.david.task_3_fragments_lists.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Creación de Base de datos
@Database(entities = {Communities.class, Lesson.class}, version = 2)
@TypeConverters(LanguageConverter.class)
public abstract class UtadDatabase extends RoomDatabase {
    public abstract IUtadDao utadDao();
    public abstract ILessonDao lessonDA0();
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
    static Callback callBackDataLesson = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            (new LessonAsyncTask(INSTANCE)).execute();
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

            HashMap<Integer, String> event1 = new HashMap<Integer, String>();
            event1.put(1, "19");
            event1.put(2, "3");
            event1.put(2, "Programame");
            event1.put(3, "Android App");
            event1.put(4, "****");

            HashMap<Integer, String> event2 = new HashMap<Integer, String>();
            event2.put(1, "32");
            event2.put(2, "2");
            event2.put(3, "SouthSummit");
            event2.put(4, "IOS App");
            event2.put(5, "*****");

            HashMap<Integer, String> event3 = new HashMap<Integer, String>();
            event3.put(1, "26");
            event3.put(2, "1");
            event3.put(3, "CompanyDay");
            event3.put(4, "WebApp");
            event3.put(5, "***");

            HashMap<Integer, String> event4 = new HashMap<Integer, String>();
            event4.put(1, "14");
            event4.put(2, "3");
            event4.put(3, "Hackaton");
            event4.put(4, "DatabaseApp");
            event4.put(5, "**");
            Communities developers = new Communities("Desarrollo de Software",1, "Dani", "Android", "9:00-10:45", "2018", event1);
            Communities segurity = new Communities("Ciberseguridad",2, "David", "Android", "9:00-10:45", "2018", event2);
            Communities bigData = new Communities("BigData",3, "Pedro", "Procesos", "11:00-12:45", "2018", event3);
            Communities virtualReality = new Communities("Realidad Virtual",4, "David", "Android", "9:00-10:45", "2018", event4);
            List<Communities> data = new ArrayList<>();
            data.add(developers);
            data.add(segurity);
            data.add(bigData);
            data.add(virtualReality);
            utadDao.deleteAllComunities();
            utadDao.insertAllComunities(data);
            return null;
        }
        public void doNotifications(){
            /*Notifications notifications1 = new Notifications("2018/08/28", "David", "New Note");
            Notifications notifications2 = new Notifications("2018/09/06", "Pablo", "New Event");
            Notifications notifications3 = new Notifications("2018/09/10", "Sebas", "New work");
            Notifications notifications4 = new Notifications("2018/10/15", "Nacho", "New Note");
            List<Notifications> data = new ArrayList<>();
            data.add(notifications1);
            data.add(notifications2);
            data.add(notifications3);
            data.add(notifications4);
            utadDao.deleteAllNotifications();
            utadDao.insertAllNotifications(data);*/
        }
    }
    private static class LessonAsyncTask extends AsyncTask<Void,Void,Void> {
        public ILessonDao lessonDAO;

        public LessonAsyncTask(UtadDatabase bdUtad) {
            lessonDAO = bdUtad.lessonDA0();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            HashMap<Integer, String> stadistic1 = new HashMap<Integer, String>();
            stadistic1.put(1, "25");
            stadistic1.put(2, "David");
            stadistic1.put(2, "8.1");
            stadistic1.put(3, "9");
            stadistic1.put(4, "8");

            HashMap<Integer, String> estadisticas2 = new HashMap<Integer, String>();
            estadisticas2.put(1, "32");
            estadisticas2.put(2, "Meritxel");
            estadisticas2.put(3, "SouthSummit");
            estadisticas2.put(4, "IOS App");
            estadisticas2.put(5, "*****");

            HashMap<Integer, String> estadisticas3 = new HashMap<Integer, String>();
            estadisticas3.put(1, "26");
            estadisticas3.put(2, "Laura");
            estadisticas3.put(3, "CompanyDay");
            estadisticas3.put(4, "WebApp");
            estadisticas3.put(5, "***");

            HashMap<Integer, String> estadisticas4 = new HashMap<Integer, String>();
            estadisticas4.put(1, "14");
            estadisticas4.put(2, "Pedro");
            estadisticas4.put(3, "Hackaton");
            estadisticas4.put(4, "DatabaseApp");
            estadisticas4.put(5, "**");

            HashMap<Integer, String> estadisticas6 = new HashMap<Integer, String>();
            estadisticas6.put(1, "14");
            estadisticas6.put(2, "Jaime");
            estadisticas6.put(3, "Hackaton");
            estadisticas6.put(4, "DatabaseApp");
            estadisticas6.put(5, "**");

            HashMap<Integer, String> estadisticas5 = new HashMap<Integer, String>();
            estadisticas5.put(1, "14");
            estadisticas5.put(2, "Cristina");
            estadisticas5.put(3, "Hackaton");
            estadisticas5.put(4, "DatabaseApp");
            estadisticas5.put(5, "**");

            HashMap<Integer, String> estadisticas7 = new HashMap<Integer, String>();
            estadisticas7.put(1, "14");
            estadisticas7.put(2, "Carlos");
            estadisticas7.put(3, "Hackaton");
            estadisticas7.put(4, "DatabaseApp");
            estadisticas7.put(5, "**");

            Lesson lesson1 = new Lesson("DINT", R.drawable.dint, "2018", "Desarrollo de interfaces",estadisticas7);
            Lesson lesson2 = new Lesson("EIEM", R.drawable.eiem, "2018", "Empresa e iniciativa emprendedora", stadistic1);
            Lesson lesson3 = new Lesson("SGEM", R.drawable.sgem, "2018", "Sistemas de gestión empresarial", estadisticas2);
            Lesson lesson4 = new Lesson("PSPR", R.drawable.pspr, "2018", "Programación de servicios y procesos", estadisticas3);
            Lesson lesson5 = new Lesson("ADAT", R.drawable.acceso_datos, "2018", "Acceso a datos",estadisticas4);
            Lesson lesson6 = new Lesson("ITGS", R.drawable.english, "2018", "Inglés técnico de grado superior", estadisticas5);
            Lesson lesson7 = new Lesson("PMDM", R.drawable.pmdm, "2018", "Programación en dispositivos multimedia", estadisticas6);

            List<Lesson> data = Arrays.asList(lesson1,lesson2,lesson3,lesson4,lesson5,lesson6,lesson7);
            lessonDAO.deleteAllLessons();
            lessonDAO.insertAllLessons(data);
            return null;
        }
    }

}
