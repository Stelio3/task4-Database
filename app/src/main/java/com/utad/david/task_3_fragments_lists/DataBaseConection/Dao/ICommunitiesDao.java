package com.utad.david.task_3_fragments_lists.DataBaseConection.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Communities;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Lesson;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Notes;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Notifications;
import com.utad.david.task_3_fragments_lists.DataBaseConection.Model.Teacher;

import java.util.List;

@Dao
public interface ICommunitiesDao {
    //Querys de Communities
    @Insert
    void insertAllComunities(List<Communities> clases);

    @Delete
    void deleteComunity(Communities clases);

    @Query("DELETE FROM communities")
    void deleteAllComunities();

    @Query("SELECT * FROM communities")
    LiveData<List<Communities>> getAllComunities();
}
