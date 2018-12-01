package com.utad.david.task_3_fragments_lists.DataBaseConection.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Dao.IUtadDao;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Database.UtadDatabase;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Communities;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Lesson;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Notes;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Notifications;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Teacher;

import java.util.List;

public class UtadRepository {
    private IUtadDao mUtadDao;
    private LiveData<List<Communities>> mAllCommunities;
    private LiveData<List<Lesson>> mAllLessons;
    private LiveData<List<Notifications>> mAllNotifications;
    private LiveData<List<Notes>> mAllNotes;
    private LiveData<List<Teacher>> mAllTeachers;

    //Constructor que llama al método que tiene la query de Select *
    public UtadRepository(Application application) {
        UtadDatabase db = UtadDatabase.getDatabase(application);
        mUtadDao = db.utadDao();
        mAllCommunities = mUtadDao.getAllComunities();
        mAllLessons = mUtadDao.getAllLessons();
        mAllNotifications = mUtadDao.getAllNotifications();
        mAllNotes = mUtadDao.getAllNotes();
        mAllTeachers = mUtadDao.getAllTeachers();
    }
    public LiveData<List<Communities>> getAllCommunities() {
        return mAllCommunities;
    }
    public LiveData<List<Lesson>> getAllLessons() {
        return mAllLessons;
    }
    public LiveData<List<Notifications>> getAllNotifications() {
        return mAllNotifications;
    }
    public LiveData<List<Notes>> getAllNotes() {
        return mAllNotes;
    }
    public LiveData<List<Teacher>> getAllTeachers() {
        return mAllTeachers;
    }
}
