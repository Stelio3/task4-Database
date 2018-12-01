package com.utad.david.task_3_fragments_lists.DataBaseConection.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.IUtadDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Communities;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Lesson;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Notes;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Notifications;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Teacher;
import com.utad.david.task_3_fragments_lists.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Creación de Base de datos
@Database(entities = {Communities.class, Lesson.class, Notifications.class, Notes.class, Teacher.class}, version = 6)
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
                            .addCallback(callbackDataCommunities)
                            .addCallback(callBackDataLesson)
                            .addCallback(callBackDataNotifications)
                            .addCallback(callBackDataNotes)
                            .addCallback(callBackDataTeachers)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // Creación del callBack
    static Callback callbackDataCommunities = new Callback() {
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
    static Callback callBackDataNotifications = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            (new NotificationsAsyncTask(INSTANCE)).execute();
        }
    };
    static Callback callBackDataNotes = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            (new NotesAsyncTask(INSTANCE)).execute();
        }
    };
    static Callback callBackDataTeachers = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            (new TeachersAsynTask(INSTANCE)).execute();
        }
    };

    private static class ClassAsynTask extends AsyncTask<Void, Void, Void> {

        public IUtadDao utadDao;

        public ClassAsynTask(UtadDatabase instance) {
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
            Communities developers = new Communities("Desarrollo de Software", R.drawable.desarrollo_software, "Dani", "Android", "9:00-10:45", "2018", event1);
            Communities segurity = new Communities("Ciberseguridad", R.drawable.ciberseguridad, "David", "Android", "9:00-10:45", "2018", event2);
            Communities bigData = new Communities("BigData", R.drawable.big_data, "Pedro", "Procesos", "11:00-12:45", "2018", event3);
            Communities virtualReality = new Communities("Realidad Virtual", R.drawable.vr, "David", "Android", "9:00-10:45", "2018", event4);
            List<Communities> data = new ArrayList<>();
            data.add(developers);
            data.add(segurity);
            data.add(bigData);
            data.add(virtualReality);
            utadDao.deleteAllComunities();
            utadDao.insertAllComunities(data);
            return null;
        }
    }

    private static class LessonAsyncTask extends AsyncTask<Void, Void, Void> {
        public IUtadDao lessonDAO;

        public LessonAsyncTask(UtadDatabase bdUtad) {
            lessonDAO = bdUtad.utadDao();
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

            Lesson lesson1 = new Lesson("DINT", R.drawable.dint, "2018", "Desarrollo de interfaces", estadisticas7);
            Lesson lesson2 = new Lesson("EIEM", R.drawable.eiem, "2018", "Empresa e iniciativa emprendedora", stadistic1);
            Lesson lesson3 = new Lesson("SGEM", R.drawable.sgem, "2018", "Sistemas de gestión empresarial", estadisticas2);
            Lesson lesson4 = new Lesson("PSPR", R.drawable.pspr, "2018", "Programación de servicios y procesos", estadisticas3);
            Lesson lesson5 = new Lesson("ADAT", R.drawable.acceso_datos, "2018", "Acceso a datos", estadisticas4);
            Lesson lesson6 = new Lesson("ITGS", R.drawable.english, "2018", "Inglés técnico de grado superior", estadisticas5);
            Lesson lesson7 = new Lesson("PMDM", R.drawable.pmdm, "2018", "Programación en dispositivos multimedia", estadisticas6);

            List<Lesson> data = Arrays.asList(lesson1, lesson2, lesson3, lesson4, lesson5, lesson6, lesson7);
            lessonDAO.deleteAllLessons();
            lessonDAO.insertAllLessons(data);
            return null;
        }
    }

    private static class NotificationsAsyncTask extends AsyncTask<Void, Void, Void> {
        public IUtadDao notificationsDAO;

        public NotificationsAsyncTask(UtadDatabase bdUtad) {
            notificationsDAO = bdUtad.utadDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Notifications notifications1 = new Notifications("2018/08/28", "David", "New Note");
            Notifications notifications2 = new Notifications("2018/09/06", "Pablo", "New Event");
            Notifications notifications3 = new Notifications("2018/09/10", "Sebas", "New work");
            Notifications notifications4 = new Notifications("2018/10/15", "Nacho", "New Note");
            List<Notifications> data = new ArrayList<>();
            data.add(notifications1);
            data.add(notifications2);
            data.add(notifications3);
            data.add(notifications4);
            notificationsDAO.deleteAllNotifications();
            notificationsDAO.insertAllNotifications(data);
            return null;
        }
    }

    private static class NotesAsyncTask extends AsyncTask<Void, Void, Void> {
        public IUtadDao notesDao;

        public NotesAsyncTask(UtadDatabase bdUtad) {
            notesDao = bdUtad.utadDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Notes notes1 = new Notes("2018/11/18", "Android", "Listas", "9");
            Notes notes2 = new Notes("2018/11/09", "IOS", "Tablas", "8.5");
            Notes notes3 = new Notes("2018/10/28", "Procesos", "Semáforos", "6.5");
            Notes notes4 = new Notes("2018/10/19", "Ingles", "Reading", "7.5");
            Notes notes5 = new Notes("2018/10/14", "Acceso a datos", "Hibernate", "10");
            Notes notes6 = new Notes("2018/10/10", "Empresa", "Plan de empresa", "10");
            Notes notes7 = new Notes("2018/09/28", "GG Empresarial", "Odoo", "6.5");
            List<Notes> data = new ArrayList<>();
            data.add(notes1);
            data.add(notes2);
            data.add(notes3);
            data.add(notes4);
            data.add(notes5);
            data.add(notes6);
            data.add(notes7);
            notesDao.deleteAllNotes();
            notesDao.insertAllNotes(data);
            return null;
        }
    }

    private static class TeachersAsynTask extends AsyncTask<Void, Void, Void> {

        public IUtadDao teachersDao;

        public TeachersAsynTask(UtadDatabase instance) {
            teachersDao = instance.utadDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            HashMap<Integer, String> subject1 = new HashMap<Integer, String>();
            subject1.put(1,"Acceso a datos");
            subject1.put(2,"Base de datos");
            subject1.put(3,"Lenguaje de marcas");

            HashMap<Integer, String> subject2 = new HashMap<Integer, String>();
            subject2.put(1,"Desarollo de interfaces");
            subject2.put(2,"Programación");
            subject2.put(3,"Sistemas Informaticos");

            HashMap<Integer, String> subject3 = new HashMap<Integer, String>();
            subject3.put(1,"Ingles G.Superior");
            subject3.put(2,"Ingles G.Medio");
            subject3.put(3,"Ingles Bachillerato");

            HashMap<Integer, String> subject4 = new HashMap<Integer, String>();
            subject4.put(1,"Servicios y Procesos");
            subject4.put(2,"Programación");
            subject4.put(3,"Entornos del desarollo");

            HashMap<Integer, String> subject5 = new HashMap<Integer, String>();
            subject5.put(1,"Empresa");
            subject5.put(2,"Fol");
            subject5.put(3,"Ingles");

            HashMap<Integer, String> subject6 = new HashMap<Integer, String>();
            subject6.put(1,"S.G.Empresarial");
            subject6.put(2,"Entornos del desarollo");
            subject6.put(3,"Programaciòn");

            HashMap<Integer, String> subject7 = new HashMap<Integer, String>();
            subject7.put(1,"Ios");
            subject7.put(2,"Programacion");
            subject7.put(3,"Base de datos");

            Teacher teacher1 = new Teacher("Jaime", "Latorre", R.drawable.jaime, subject1, "Experto en SQL", "jaime.latorre@utad.com");
            Teacher teacher2 = new Teacher("David", "Jardon", R.drawable.david, subject2, "Experto en Android", "david.jardon@utad.com");
            Teacher teacher3 = new Teacher("Cristina", " Espinosa", R.drawable.cristina, subject3, "Profesora nativa", "cristina.espinosa@utad.com");
            Teacher teacher4 = new Teacher("Pedro", "Camacho", R.drawable.pedro, subject4, "Experto en POO", "pedro.camacho@utad.com");
            Teacher teacher5 = new Teacher("Meritxel", "Bretos", R.drawable.meritxel, subject5, "Emprendedora", "meritxel.bretos@utad.com");
            Teacher teacher6 = new Teacher("Laura", "Jaen", R.drawable.laura, subject6, "Experiencia en consultoras", "laura.jaen@utad.com");
            Teacher teacher7 = new Teacher("Carlos", "Jimenez", R.drawable.ic_person_outline_black_24dp, subject7, "Experto en Ios", "carlos.jimenez@utad.com");

            List<Teacher> data = Arrays.asList(teacher1, teacher2, teacher3, teacher4, teacher5, teacher6, teacher7);
            teachersDao.deleteAllTeachers();
            teachersDao.insertAllTeachers(data);
            return null;
        }
    }
}