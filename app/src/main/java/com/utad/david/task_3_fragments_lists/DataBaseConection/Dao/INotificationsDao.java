package com.utad.david.task_3_fragments_lists.DataBaseConection.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Notifications;

import java.util.List;

@Dao
public interface INotificationsDao {
    //Querys de Notifications
    @Insert
    void insertAllNotifications(List<Notifications> clases);

    @Delete
    void deleteNotification(Notifications clases);

    @Query("DELETE FROM notifications")
    void deleteAllNotifications();

    @Query("SELECT * FROM notifications")
    LiveData<List<Notifications>> getAllNotifications();
}
