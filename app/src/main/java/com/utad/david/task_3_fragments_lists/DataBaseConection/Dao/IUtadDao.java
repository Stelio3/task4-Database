package com.utad.david.task_3_fragments_lists.DataBaseConection.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Communities;

import java.util.List;

@Dao
public interface IUtadDao {
    @Insert
    void insertAllComunities(List<Communities> clases);

    @Delete
    void deleteComunity(Communities clases);

    @Query("DELETE FROM communities")
    void deleteAllComunities();

    @Query("SELECT * FROM communities")
    LiveData<List<Communities>> getAllComunities();

    /*@Insert
    void insertAllNotifications(List<Notifications> clases);

    @Delete
    void deleteNotification(Notifications clases);

    @Query("DELETE FROM communities")
    void deleteAllNotifications();

    @Query("SELECT * FROM communities")
    LiveData<List<Notifications>> getAllNotifications();*/
}
