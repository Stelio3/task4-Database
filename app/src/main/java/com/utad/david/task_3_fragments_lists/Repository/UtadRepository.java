package com.utad.david.task_3_fragments_lists.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.utad.david.task_3_fragments_lists.Dao.IUtadDao;
import com.utad.david.task_3_fragments_lists.Database.UtadDatabase;
import com.utad.david.task_3_fragments_lists.Model.Communities;
import com.utad.david.task_3_fragments_lists.Model.Lesson;

import java.util.List;

public class UtadRepository {
    private IUtadDao mUtadDao;
    private LiveData<List<Communities>> mAllCommunities;
    private LiveData<List<Lesson>> mAllLessons;

    //Constructor que llama al método que tiene la query de Select *
    public UtadRepository(Application application) {
        UtadDatabase db = UtadDatabase.getDatabase(application);
        mUtadDao = db.utadDao();
        mAllCommunities = mUtadDao.getAll();
        //mAllLessons = mUtadDao.getAll();
    }
    public LiveData<List<Communities>> getAllCommunities() {
        return mAllCommunities;
    }
    public LiveData<List<Lesson>> getAllLessons() {
        return mAllLessons;
    }
}
