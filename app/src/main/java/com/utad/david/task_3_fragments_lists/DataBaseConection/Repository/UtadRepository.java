package com.utad.david.task_3_fragments_lists.DataBaseConection.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.ILessonDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.IUtadDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Database.UtadDatabase;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Communities;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Lesson;

import java.util.List;

public class UtadRepository {
    private IUtadDao mUtadDao;
    private ILessonDao mLessonDao;
    private LiveData<List<Communities>> mAllCommunities;
    private LiveData<List<Lesson>> mAllLessons;

    //Constructor que llama al método que tiene la query de Select *
    public UtadRepository(Application application) {
        UtadDatabase db = UtadDatabase.getDatabase(application);
        mUtadDao = db.utadDao();
        mLessonDao = db.lessonDA0();
        mAllCommunities = mUtadDao.getAllComunities();
        mAllLessons = mLessonDao.getAllLessons();
    }
    public LiveData<List<Communities>> getAllCommunities() {
        return mAllCommunities;
    }
    public LiveData<List<Lesson>> getAllLessons() {
        return mAllLessons;
    }
}
