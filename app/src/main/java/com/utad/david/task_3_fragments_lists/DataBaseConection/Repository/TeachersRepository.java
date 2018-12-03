package com.utad.david.task_3_fragments_lists.DataBaseConection.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.ITeachersDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Database.UtadDatabase;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Teacher;

import java.util.List;

public class TeachersRepository {
    private ITeachersDao teachersDao;
    private LiveData<List<Teacher>> mAllTeachers;

    public TeachersRepository(Application application) {
        UtadDatabase db = UtadDatabase.getDatabase(application);
        teachersDao = db.teachersDao();
        mAllTeachers = teachersDao.getAllTeachers();
    }

    public LiveData<List<Teacher>> getAllTeachers() {
        return mAllTeachers;
    }
}
