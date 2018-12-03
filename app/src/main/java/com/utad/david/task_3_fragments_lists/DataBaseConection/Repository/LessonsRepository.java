package com.utad.david.task_3_fragments_lists.DataBaseConection.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.ILessonsDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Database.UtadDatabase;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Lesson;

import java.util.List;

public class LessonsRepository {
    private ILessonsDao lessonsDao;
    private LiveData<List<Lesson>> mAllLessons;

    public LessonsRepository(Application application) {
        UtadDatabase db = UtadDatabase.getDatabase(application);
        lessonsDao = db.lessonsDao();
        mAllLessons = lessonsDao.getAllLessons();
    }

    public LiveData<List<Lesson>> getAllLessons() {
        return mAllLessons;
    }
}
